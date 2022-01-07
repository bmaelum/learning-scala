package com.sundogsoftware.spark

import breeze.linalg.sum
import com.sundogsoftware.spark.MinTemperatures.parseLine
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object TotalAmountSpentBmaelum {

  def parseLine(line:String): (Int, Float) = {
    val fields = line.split(",")
    val customerId = fields(0).toInt
    val amount = fields(2).toFloat
    (customerId, amount)
  }

  // Find the total amount spent per customer

  /** Our main function where the action happens */
  def main(args: Array[String]) {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "TotalAmountSpentBmaelum")

    // Read each line of input data
    val lines = sc.textFile("data/customer-orders.csv")

    // Convert to fields
    val parsedLines = lines.map(parseLine)

    val summed = parsedLines.reduceByKey((x,y) => x + y)

    val results = summed.collect()

    results.foreach(println)


  }
}
