package com.tron.client;

public class Runner {

  public void listen() {
    // 1.轮训监听配置的oracle合约地址事件
    // 2.判断事件类型job是否支持
    // 3.将事件入库，并标记为待处理
  }

  public void fulfil() {
    // 从已完成的事件库中获取已完成的request，将结果返回给oracle合约
  }

  public void run() {
    listen(); //单起线程
    fulfil(); //单起线程
  }
}
