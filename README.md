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
 
