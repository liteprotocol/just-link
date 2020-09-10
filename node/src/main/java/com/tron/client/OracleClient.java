package com.tron.client;

/**
 * Subscribe the events of the oracle contracts and reply.
 * todo: this class name may need be optimized
 */
public class OracleClient {

  public void listen() {
    // 1.listen the events of the oracle contracts
    // 2.check whether the event is supported by this node
    // 3.put the events into db, and mark them as TO_BE_PROCESSED.
  }

  public void fulfil() {
    // iterate the finished events and send the responses to the oracle contracts
  }

  public void run() {
    listen(); // better start in another thread
    fulfil(); // better start in another thread
  }
}
