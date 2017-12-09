@echo off

set base=%~dp0

set class=%base%target\classes
set libs=D:\mywork\WorkTools\MavenTool\mvn_repo\commons-io\commons-io\2.6\commons-io-2.6.jar;D:\mywork\WorkTools\MavenTool\mvn_repo\io\netty\netty-all\4.1.17.Final\netty-all-4.1.17.Final.jar;D:\mywork\WorkTools\MavenTool\mvn_repo\com\fasterxml\jackson\core\jackson-core\2.9.2\jackson-core-2.9.2.jar;D:\mywork\WorkTools\MavenTool\mvn_repo\com\fasterxml\jackson\core\jackson-databind\2.9.2\jackson-databind-2.9.2.jar;D:\mywork\WorkTools\MavenTool\mvn_repo\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar

set class_path=%class%;%libs%

java  -Xms128M -Xmx256M  -classpath  %class_path%  com.nio.netty.demo.discard.DiscardServer 8081

echo end.

@pause
