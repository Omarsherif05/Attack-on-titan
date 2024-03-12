package game.engine.interfaces;
public interface Attackee 	 {
	
	  void setCurrentHealth(int currentHealth);
	  int getCurrentHealth();
	  int getResourcesValue();
	 /* 
	///
	  default  int getCurrentHealth (){
	  return CurrentHealth;
	  }
	///
	  default  void setCurrentHealth (int health){
		  CurrentHealth=health;
		  }
	///  
	  default  int getResourcesValue(){
		  return ResourcesValue;
		  }
	  
	  */
	  
}
/*where should i make the implemntation class or should this interface being inherited from anothor class */