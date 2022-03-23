#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2022/3/8 17:51
# @Author  : maochong
# @File    : OrderMan.py
from LBank.APIV2Excu import APIV2Excu


class OrderMan:
  def __init__(self):
    self.excuReq = APIV2Excu()

  def getCreate_order_test(self, **d):
    str = self.getCreate_order_test.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getCreate_order(self, **d):
    str = self.getCreate_order.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getCancel_orderV2(self, **d):
    str = self.getCancel_orderV2.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getCancel_order_by_symbol(self, **d):
    str = self.getCancel_order_by_symbol.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getCancel_order_by_symbol(self, **d):
    str = self.getCancel_order_by_symbol.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getOrders_infoV2(self, **d):
    str = self.getOrders_infoV2.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getOrders_info_no_deal(self, **d):
    str = self.getOrders_info_no_deal.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getOrders_info_history(self, **d):
    str = self.getOrders_info_history.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getUser_info_account(self, **d):
    str = self.getUser_info_account.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)

  def getTransaction_history(self, **d):
    str = self.getTransaction_history.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]
    self.excuReq.ExcuRequests(par, str)