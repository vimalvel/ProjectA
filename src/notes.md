1. constructor automatically invoked when application context is loaded  
 1. first JVM gets loaded  
 1. main method gets executed  
 1. ApplicationContext is loaded  
 1. ApplicationContext reads xml configuration file  
 1. ApplicationContext pre-loads one object for each bean in the config file   
 1. if bean is marked as lazy-init="true"  
 1. lazy-init "true" This informs springContainer not to pre-load object for this bean  
 1. By default Spring early loads objects in memory.  
 1. for lazy-init beans object is created only when getBean() method is called.  
 1. for pre-init beans getBean() returns the reference of the pre-loaded object.  
 1. By defalut only one object for every bean is created(singleton).  
 1. singleton: Atleast one object for every class but not more than one object  
 1. spring for lazy-init beans creates a single object on firstcall of getBeans() method  
 1. and then uses that object for future getBean() method calls  
 
 ----------  
 
##Prototype  
Prototype beans are by default lazy-init  
Prototype are not singleton  
A new object is created for Prototype when getBean() method is called every time
	
```
   	<bean id="act" class="com.chainsys.projectA.beans.Actor" scope="prototype"> </bean>
```		  

-------
// constructor automatically invoked when application context is loaded
// First JVM gets loaded
// Main method gets executed
// ApplicationContext is loaded
// ApplicationContext pre loads one object for each bean in the config file
// lazy-init="true" this informs sprincontainer not pre load object fo this beans
// by default spring early loads objects in memory
// For lazy-init beans object is created only when the getbeans() method is called.
