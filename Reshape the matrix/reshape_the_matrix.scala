def matrixReshape(mat:Array[Array[Int]],r:Int,c:Int):Array[Array[Int]] = {
  val m = mat.length
  val n = mat(0).length
  if (m*n != r*c)
    return mat
  val res = Array.ofDim[Int](r,c)
  var k = 0
  for(i<-0 until m;j<-0 until n){
    res(k/c)(k%c) = mat(i)(j)
    k+=1
  }
  res
}


val mat = Array(Array(1,2),Array(3,4))
val r = 1
val c = 4
val reshaped = matrixReshape(mat,r,c)
println(reshaped)
println(reshaped.map(_.mkString(",").mkString("\n")))