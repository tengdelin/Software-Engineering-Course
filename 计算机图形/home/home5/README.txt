光线的生成:
这里需要为每个像素生成一条对应的光线，然后调用函数 castRay() 来得到颜色，最后将颜色存储在帧缓冲区的相应像素中。 

光线与三角的相交:
 v0, v1, v2 是三角形的三个顶点，orig 是光线的起点，dir是光线单位化的方向向量。tnear, u, v 是需要使用我们课上推导的Moller-Trumbore算法来更新的参数。
