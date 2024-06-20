package com.example.painting
//Replace class Constants.kt
object PaintsList {
    //    object Constants {
    // This Method create an Painting
    // Arraylist and return the Arraylis
    fun getPaintsList():ArrayList<PaintDetail>{
        // create an arraylist of paintings
        val employeeList=ArrayList<PaintDetail>()
        val emp1=PaintDetail(listOf(R.drawable.ccunsaimage1))
        employeeList.add(emp1)
        val emp2=PaintDetail(listOf(R.drawable.ccunsaimage2))
        employeeList.add(emp2)
        val emp3=PaintDetail(listOf(R.drawable.ccunsaimage3))
        employeeList.add(emp3)
        val emp4=PaintDetail(listOf(R.drawable.ccunsaimage4))
        employeeList.add(emp4)
        val emp5=PaintDetail(listOf(R.drawable.ccunsaimage5))
        employeeList.add(emp5)
        val emp6=PaintDetail(listOf(R.drawable.ccunsaimage6))
        employeeList.add(emp6)
        val emp7=PaintDetail(listOf(R.drawable.ccunsaimage7))
        employeeList.add(emp7)
        val emp8=PaintDetail(listOf(R.drawable.ccunsaimage8))
        employeeList.add(emp8)
        val emp9=PaintDetail(listOf(R.drawable.ccunsaimage9))
        employeeList.add(emp9)
        val emp10=PaintDetail(listOf(R.drawable.ccunsaimage10))
        employeeList.add(emp10)
        return  employeeList
        }
}