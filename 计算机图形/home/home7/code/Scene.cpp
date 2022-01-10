//
// Created by Göksu Güvendiren on 2019-05-14.
//

#include "Scene.hpp"

void Scene::buildBVH()
{
    printf(" - Generating BVH...\n\n");
    this->bvh = new BVHAccel(objects, 1, BVHAccel::SplitMethod::NAIVE);
}

Intersection Scene::intersect(const Ray &ray) const
{
    return this->bvh->Intersect(ray);
}

void Scene::sampleLight(Intersection &pos, float &pdf) const
{
    float emit_area_sum = 0;
    for (uint32_t k = 0; k < objects.size(); ++k)
    {
        if (objects[k]->hasEmit())
        {
            emit_area_sum += objects[k]->getArea();
        }
    }
    float p = get_random_float() * emit_area_sum;
    emit_area_sum = 0;
    for (uint32_t k = 0; k < objects.size(); ++k)
    {
        if (objects[k]->hasEmit())
        {
            emit_area_sum += objects[k]->getArea();
            if (p <= emit_area_sum)
            {
                objects[k]->Sample(pos, pdf);
                break;
            }
        }
    }
}

bool Scene::trace(
    const Ray &ray,
    const std::vector<Object *> &objects,
    float &tNear, uint32_t &index, Object **hitObject)
{
    *hitObject = nullptr;
    for (uint32_t k = 0; k < objects.size(); ++k)
    {
        float tNearK = kInfinity;
        uint32_t indexK;
        Vector2f uvK;
        if (objects[k]->intersect(ray, tNearK, indexK) && tNearK < tNear)
        {
            *hitObject = objects[k];
            tNear = tNearK;
            index = indexK;
        }
    }

    return (*hitObject != nullptr);
}

Vector3f Scene::castRay(const Ray &ray, int depth) const
{
    float pdf;
    Vector3f color1 = {.0, .0, .0}, color2 = {.0, .0, .0};
    Intersection intersection = Scene::intersect(ray);
    //找不到这个投射点.
    if (!intersection.happened)
    {
        return {};
    }
    //这里想不通如何判断是否是光的看的别人
    //如果射线打到光   //hasEmission函数m->m_emission向量的距离是否大于0.00001}
    //在main中定义了光材质Material* light = new Material(DIFFUSE, Vector3f(0.747f+0.058f, 0.747f+0.258f, 0.747f)....);
    //其他材质创建时 第二个传参值都是Vector3f(0.0f);
    // 第二传参值定义了m->m_emission也就是说除了光其他 调用 hasEmission函数都是false
    if (intersection.m->hasEmission())
    {
        return intersection.m->m_emission;
    } //之后的都是 有投射点且不是光
    Material *mater = intersection.m;
    Intersection light_inter;
    sampleLight(light_inter, pdf);
    Vector3f light_point_v3 = light_inter.coords - intersection.coords;
    Vector3f point_light_dir = light_point_v3.normalized();
    float point_light_dis_pow2 = light_point_v3.x * light_point_v3.x + light_point_v3.y * light_point_v3.y + light_point_v3.z * light_point_v3.z;
    float point_light_dis = std::sqrt(point_light_dis_pow2);
    //光比物体近   还要考虑物体和光距离一样的情况  这里还是看别人写的才发现的 的确考虑不周
    //进度问题 这里写成了>= -0.00005f  写小了就会有横条
    if ((intersect(Ray(intersection.coords, point_light_dir)).distance - point_light_dis) >= -0.00005f)
    {
        //需知 光源烈度 * BRDF * cos(交点法线,交点到光方向) * cos(光源法线,-交点到光方向)  / PDF / 距离^2
        color1 = light_inter.emit * mater->eval(ray.direction, point_light_dir, intersection.normal) * dotProduct(intersection.normal, point_light_dir) * dotProduct(light_inter.normal, -point_light_dir) / pdf / point_light_dis_pow2;
    }
    float p = (float)(rand() % 100) / 100;
    if (p > RussianRoulette)
    {
        return color1;
    }
    Vector3f l_exit_dir = mater->sample(ray.direction, intersection.normal);
    Ray l_exit = Ray(intersection.coords, l_exit_dir);
    Intersection inter_sequel = intersect(l_exit);
    //如何判断这个射线射没射到光源?
    if (inter_sequel.happened && !inter_sequel.m->hasEmission())
    {
        color2 = castRay(l_exit, depth + 1) * mater->eval(ray.direction, l_exit_dir, intersection.normal) * dotProduct(intersection.normal, l_exit_dir) / mater->pdf(ray.direction, l_exit_dir, intersection.normal) / RussianRoulette;
    }
    return color1 + color2;
}