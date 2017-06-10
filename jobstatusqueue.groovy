import groovy.json.JsonSlurper


node {


   stage('Publish') {
       
       
   sh '''
   
 QUEUEID=`curl -k -v --user  packer-us1n:packer-us1n http://packer-us1n.cloud.pw.ge.com/jenkins/job/testjob/build/?token=test 2>&1 | grep Location | cut -d"/" -f7`

 echo $QUEUEID
 
    if [ "$QUEUEID" != null ]; then
    
      JOBID=$(curl -k -s --user packer-us1n:packer-us1n  http://packer-us1n.cloud.pw.ge.com/jenkins/queue/item/"$QUEUEID"/api/json | jq -r .executable.number)
      
     while [ $JOBID == null ];
      do
          echo waiting  for job to get jobid
          sleep 10
          JOBID=$(curl -k -s --user packer-us1n:packer-us1n  http://packer-us1n.cloud.pw.ge.com/jenkins/queue/item/"$QUEUEID"/api/json | jq -r .executable.number)
          echo "********************************"
          
      done
      
    else
          echo fail
    fi
 
 
      echo $JOBID
 
  '''

   
    }

}
 
 
 