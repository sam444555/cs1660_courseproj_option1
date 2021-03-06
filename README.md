# cs1660_courseproj_option1<br />
Steps on how to set up the cluster/run it and other fun stuff<br />
__________________________________________________________________________<br />
## To pull containers from docker and push them to gcp container registry, utilize the following commands (in order):  
[1]. docker pull image_name  //replace image name with whatever the desired image is  
[2]. docker tag image_name gcr.io/my-project/image_name //replace my-project with whatever the name of your project is  
[3]. docker push gcr.io/my-project/image_name //replace my-project with whatever the name of your project is  

## Images 
spark image = https://hub.docker.com/repository/docker/slasky777/spark  
driver image = https://hub.docker.com/repository/docker/slasky777/driver_n <br/>
hadoop data node image = https://hub.docker.com/repository/docker/slasky777/dn <br/>
hadoop name node image = https://hub.docker.com/repository/docker/slasky777/nn <br/>
sonar image = https://hub.docker.com/repository/docker/slasky777/sonar <br/>
jupyter image = https://hub.docker.com/repository/docker/slasky777/jupy <br/>  

## Driver Program  
Now that the images are pulled and (presumably) in your GCP container registry, do the following:  
1.  Go into the driver folder and once inside, do the command: kubectl apply -f drive_deployment.yaml  
   This will deploy the container to your cluster.  Read through the contents of this file to personalize it for your deployment.  
2. The container is now executing on the cluster, to start the program run the following commands:  
    a.  kubectl get pods   
    b.  get the name of the driver pod  
    c.  kubectl exec -it <driver pod's name> /bin/bash  
3.  We're now inside the pod's terminal.  To execute the driver program, run the command:  java driver  
4.  The driver should (hopefully) launch.  

## hadoop  
1.  On GCP, go to the kubernetes (assuming you have a running cluster) and at the top select deploy (select name node image) 
2.  Name the node namenode and add the environment variables:  
    a.  CLUSTER_NAME=test  
    b.  CORE_CONF_fs_defaultFS=hdfs://namenode:9000   
    c.  CORE_CONF_hadoop_http_staticuser_user=root  
    d.  CORE_CONF_hadoop_proxyuser_hue_hosts=*  
    e.  CORE_CONF_hadoop_proxyuser_hue_groups=*  
    f.  CORE_CONF_io_compression_codecs=org.apache.hadoop.io.compress.SnappyCodec  
    g.  HDFS_CONF_dfs_webhdfs_enabled=true  
    h.  HDFS_CONF_dfs_permissions_enabled=false  
    i.  HDFS_CONF_dfs_namenode_datanode_registration_ip___hostname___check=false  
3.  In the yaml file, set the # of replicas to 1  
4.  Expose the service with the loadbalancer option selected, with ports 9870:9870 and 9000:9000  
5.  Select deploy again, but this time picking the data node 
6.  Add the env variable SERVICE_PRECONDITION: "namenode:9870", but replace "namenode:9870" without parans:  
    a. enter: kubectl get pod -o wide  
    b. find the ip for the namenode and copy it  
    c. replace namenode with the ip, making the env <name node ip: 9870>  
7.  do the same env variables for the namenode (not including option a) and replace option b's hdfs://namenode:9000 with hdfs://<namenode ip>:9000  
8.  go into the yaml for the data node and set replicas = 2  
9.  hadoop link:  http://146.148.48.94:9870/dfshealth.html#tab-overview  
## spark  
1. Run: kubectl apply -f spark.yaml (modify the image contents so it matches your gcp container's path for the spark image)  
2. Expose the service with the loadbalancer option selected, with ports 80:8080  
3. The web UI is running at http://34.70.141.209/
4.  To get to the terminal application, do: kubectl get pods  
5.  Find the name of the spark pod, and do:  kubectl exec -it <pod name> /bin/bash  
6.  Once inside the pod, enter:  /spark/bin/spark-shell  
7.  the shell should launch, it takes forever  
## jupyter notebook  
1.  On your cluster, select deploy  
2.  name it whatever you want 
3.  deploy it 
4.  create a service for it with the web-balancer option selected with port 80:8888  
5.  the link for jupyter-notebook: http://34.67.180.254:80  
     -if prompted for a password, enter: 0c4e150e59511c1186488f5bd60894896bcf091ec85ee9d0  
     -or if you're making your own, when the jupyter pod is being created look at the logs and look for a line that reads something like:  
      http://127.0.0.1:8888/?token=0c4e150e59511c1186488f5bd60894896bcf091ec85ee9d0, your password is equal to everything after "token="  
## sonar  
1.  in your cluster select deploy  
2.  select the image for slasky777/sonar in your container repository  
3.  deploy it 
4.  expose it with the loadbalancer option selected with ports 80:9000  
5.  sonar url:  http://34.134.103.155/  
6.  if prompted, login should be admin for both user and password  
## Wrapping things up  
Demo walkthrough (.mov format) >> https://app.box.com/s/bkepyyzwwwg223pdmhwar43w8sbpp21z  
Demo walkthrough (.mp4 format) >> https://app.box.com/s/a9bv9e9e7gfx4twc8r2l0if6n6jagecf  
I couldn't use my student box account because i reached my limit, so i had to use an alternative (i don't know if that matters or not).  

   The code for the driver program is in the driver folder 



 
