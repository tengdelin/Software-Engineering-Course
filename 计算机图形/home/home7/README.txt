1.将作业6中的三个函数
Triangle::getIntersection in Triangle.hpp
IntersectP(const Ray& ray, const Vector3f& invDir,const std::array<int, 3>& dirIsNeg) in the Bounds3.hpp
getIntersection(BVHBuildNode* node, const Ray ray)in BVH.cpp
根据指导，复制到相应位置，然后调整好框架后，进行编译，发现没有报错后开始编写路径追踪算法


2.编写路径追踪算法
一开始有一个要直接判断是否与光源相交的过程，这个一个是体现直接照射，第二个是在后面的递归中终止递归
我们将光照对物体表面某一点的贡献分为光源和其他反射物，当光源直接能够打到物体上时，不需要再考虑其他反射物的贡献，因为这根光线直接击中了光源
需要判断每一根光线是否击中光源
没有击中光源才需要通过 Russian Roulette 来计算其他反射物的光照贡献（间接光照）

3.运行
手动修改 Renderer::Render 里spp 参数(也就是每个像素采样次数) 
