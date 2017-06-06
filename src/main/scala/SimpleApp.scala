import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val logData = sc.parallelize(1 to 10)
    val gtFive = logData.filter(num => num > 5).count()
    println("Numbers gt 5: %s".format(gtFive))
    sc.stop()
  }
}
