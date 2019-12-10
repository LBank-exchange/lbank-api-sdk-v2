# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-10 14:28
# project name: project
# file name : run

import demo.Module as mo


if __name__=="__main__":

    excuAPIV2=mo.APIV2Excu()

    ###create orders#####
    par = {}

    excuAPIV2.UserInfo(par)
