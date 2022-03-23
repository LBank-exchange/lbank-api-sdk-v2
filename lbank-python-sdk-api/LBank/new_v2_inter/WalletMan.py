#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2022/3/8 16:16
# @Author  : maochong
# @File    : WalletMan.py
from LBank.APIV2Excu import APIV2Excu


class WalletMan:
  def __init__(self):
    self.excuReq = APIV2Excu()

  def getSystem_status(self, **d):
    str = self.getSystem_status.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getUser_info(self, **d):
    str = self.getUser_info.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getWithdraw(self, **d):
    str = self.getWithdraw.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getDeposit_history(self, **d):
    str = self.getDeposit_history.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getWithdraws(self, **d):
    str = self.getWithdraws.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def get_deposit_address(self, **d):
    str = self.get_deposit_address.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getAsset_detail(self, **d):
    str = self.getAsset_detail.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getCustomer_trade_fee(self, **d):
    str = self.getCustomer_trade_fee.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)

  def getapi_Restrictions(self, **d):
    str = self.getapi_Restrictions.__name__

    par = {}
    for key in d.keys():
      par[key] = d[key]

    self.excuReq.ExcuRequests(par, str)