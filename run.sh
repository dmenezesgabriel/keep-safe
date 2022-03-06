mvn clean package \
  -Dmaven.test.skip -DskipTests && \
mvn -e exec:java \
  -Dexec.cleanupDaemonThreads=false \
  -Dexec.mainClass="com.smartguardian.test.DataBaseTest"

mvn clean package \
  -Dmaven.test.skip -DskipTests && \
mvn -e exec:java \
  -Dexec.cleanupDaemonThreads=false \
  -Dexec.mainClass="com.smartguardian.test.CreateTest"

mvn clean package \
  -Dmaven.test.skip -DskipTests && \
mvn -e exec:java \
  -Dexec.cleanupDaemonThreads=false \
  -Dexec.mainClass="com.smartguardian.test.ReadTest"

mvn clean package \
  -Dmaven.test.skip -DskipTests && \
mvn -e exec:java \
  -Dexec.cleanupDaemonThreads=false \
  -Dexec.mainClass="com.smartguardian.test.UpdateTest"

mvn clean package \
  -Dmaven.test.skip -DskipTests && \
mvn -e exec:java \
  -Dexec.cleanupDaemonThreads=false \
  -Dexec.mainClass="com.smartguardian.test.DeleteTest"



