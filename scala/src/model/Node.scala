package com.nari.algorithm
package model

class Node(_value: Int, _left: Node, _right: Node) {

  var value: Int = _value
  var left: Node = _left
  var right: Node = _right

  def this(_value: Int) {
    this(_value, null, null)
  }
}
