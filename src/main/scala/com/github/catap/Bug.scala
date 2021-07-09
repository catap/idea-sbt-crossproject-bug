package com.github.catap

import ky.korins.blake3.Blake3

object Bug {
  def foo(): Unit = {
    Blake3.newHasher().update("Some string").doneHex(64)
  }
}
