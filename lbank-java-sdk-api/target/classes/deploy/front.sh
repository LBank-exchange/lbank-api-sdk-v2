#!/bin/bash

# 本地项目根目录
project_root='/usr/local/source/bus/exchange-bus'
# 发布的maven模块名
deploy_module='exchange-front'
# maven打包后的war包名
package_name='exchange-front.war'
# 服务器上的发布路径
server_deloy_path='/opt/server/front'
# API进程名字
process_name='front'

cd $project_root

echo '开始更新代码'
git pull origin exchange-bus-test

echo '开始maven打包...'
mvn clean install -P test-93 -DskipTests=true

echo '开始停止之前服务...'
jps -v | grep ${process_name} |awk 'NR==1{print $1}' | awk '{print $1}' | xargs kill

sleep 3s

echo '开始删除旧包...'
rm -rf ${server_deloy_path}/www/*

echo '开始复制新包...'
mv ${project_root}/exchange-front/target/${package_name} ${server_deloy_path}/www/ROOT.war

echo '开始启动服务...'
sh ${server_deloy_path}/bin/startup.sh

echo '开始显示日志...'
tail -f ${server_deloy_path}/logs/catalina.out