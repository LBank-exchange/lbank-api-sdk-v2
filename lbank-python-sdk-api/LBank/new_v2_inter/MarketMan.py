#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2022/3/8 17:19
# @Author  : maochong
# @File    : MarketMan.py
from LBank.APIV2Excu import APIV2Excu


class MarketMan:
  def __init__(self):
    self.excuReq = APIV2Excu()

  def getSystem_ping(self):
    str = self.getSystem_ping.__name__

    par = {}

    self.excuReq.ExcuRequests(par, str)

  def getIncrDepthV2(self, **d):
    str = self.getIncrDepthV2.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getTradesV2(self, **d):
    str = self.getTradesV2.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getPrice(self, **d):
    str = self.getPrice.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getBookTicker(self, **d):
    str = self.getBookTicker.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)