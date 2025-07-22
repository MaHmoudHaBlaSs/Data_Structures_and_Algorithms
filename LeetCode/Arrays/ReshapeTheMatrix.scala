object Solution {
    def matrixReshape(mat: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
        if (mat.length * mat(0).length != r * c) return mat

        val newMat: Array[Array[Int]] = Array.ofDim[Int](r, c)
        val series: Array[Int] = Array.ofDim[Int](mat.length * mat(0).length)

        var trav: Int = 0;
        for (i <- 0 until mat.length)
            for (j <- 0 until mat(0).length)
                series(trav) = mat(i)(j)
                trav += 1
        
        trav = 0
        for (i <- 0 until r)
            for (j <- 0 until c)
                newMat(i)(j) = series(trav)
                trav += 1
        
        return newMat
    }
}