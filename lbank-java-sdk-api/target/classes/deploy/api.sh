#!/bin/bash

# 本地项目根目录
project_root='/usr/local/source/api/exchange-api'
# 发布的maven模块名
deploy_module='exchange-api'
# maven打包后的war包名
package_name='exchange-api.war'
# 服务器上的发布路径
server_deloy_path='/opt/server/api'
# API进程名字
process_name='api'

cd $project_root

echo '开始更新代码'
git pull origin api-test

echo '开始maven打包...'
mvn clean install -P test -DskipTests=true

echo '开始停止之前服务...'
jps -v | grep ${process_name} |awk 'NR==1{print $1}' | awk '{print $1}' | xargs kill

sleep 3s

echo '开始删除旧包...'
rm -rf ${server_deloy_path}/www/*

echo '开始复制新包...'
mv ${project_root}/target/${package_name} ${server_deloy_path}/www/ROOT.war

echo '开始启动服务...'
sh ${server_deloy_path}/bin/startup.sh

echo '开始显示日志...'
tail -f ${server_deloy_path}/logs/catalina.out
