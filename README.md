# cs1660_courseproj_option1<br />
Steps on how to set up the cluster/run it and other fun stuff<br />
__________________________________________________________________________<br />
>>To pull containers from docker and push them to gcp container registry, utilize the following commands (in order):<br/>
[1]. docker pull image_name  #replace image name with whatever the desired image is<br />    
[2]. docker tag image_name gcr.io/my-project/image_name #replace my-project with whatever the name of your project is <br/>    
[3]. docker push gcr.io/my-project/image_name #replace my-project with whatever the name of your project is <br/>

>>Considering the above, go to the url to get the images https://github.com/sam444555/cs1660_courseproj_option1/edit/main/README.md<br />
spark image = https://hub.docker.com/repository/docker/slasky777/spark<br />
driver image = https://hub.docker.com/repository/docker/slasky777/driver_n <br />
hadoop data node image = https://hub.docker.com/repository/docker/slasky777/dn <br />
hadoop name node image = https://hub.docker.com/repository/docker/slasky777/nn <br />
sonar image = https://hub.docker.com/repository/docker/slasky777/sonar <br />
jupyter image = https://hub.docker.com/repository/docker/slasky777/jupy <br />
