package main.input

import main.util.Conf

/**
 * Created by zhy on 2015/7/19 0019.
 */

/**
 * 数据集工厂
 */
trait DataHolderFactory {
  def getName: String

  def getDescription: String

  def getDataHolderInstance(conf: Conf): DataHolder
}

object DataHolderFactory {
  val dataHolderFactories: List[DataHolderFactory] = List(YahooDataHolderFactory, NetFlixInDirectoryDataHolderFactory, NetFlixInFileDataHolderFactory)
}

object YahooDataHolderFactory extends DataHolderFactory {
  override def getName: String = "Yahoo"

  override def getDescription: String = "数据源：Yahoo数据集，单个文件\n数据格式：userID itemID(musicID) rating(0-100)"

  override def getDataHolderInstance(conf: Conf): DataHolder = {
    println(getDescription)
    new YahooDataHolder(conf.dir())
  }
}

object NetFlixInFileDataHolderFactory extends DataHolderFactory {
  override def getName: String = "NetFlixInFile"

  override def getDescription: String = "数据源：NetFlix数据集，单个文件\n数据格式：???"

  override def getDataHolderInstance(conf: Conf): DataHolder = {
    println(getDescription)
    new YahooDataHolder(conf.dir())
  }
}

object NetFlixInDirectoryDataHolderFactory extends DataHolderFactory {
  override def getName: String = "NetflixInDirectory"

  override def getDescription: String = "数据源：Yahoo数据集，目录\n数据格式：每个文件第一行为UserID，其余每行：movieID,rating(0-5),time"

  override def getDataHolderInstance(conf: Conf): DataHolder = {
    println(getDescription)
    new YahooDataHolder(conf.dir())
  }
}