package program3;
//Ben Schulz
public class Contact implements Comparable
{
	private String name = "";
	private String phone = "";
	private String image = "";
	
	public Contact(String n, String p, String img)
	{
		setName(n);
		setPhone(p);
		setImage(img);
	}//Constructor
	
	public int compareTo (Object other)
	{
	    Contact c = (Contact) other;
	    if (this.name.compareTo(c.getName()) < 0)
	      return -1;
	    else if (this.name.compareTo(c.getName()) > 0)
	      return 1;
	    else
	      return 0;
	}//compareTo

	public String getName() 
	{
		return name;
	}//getName

	public void setName(String name) 
	{
		this.name = name;
	}//setName

	public String getPhone() 
	{
		return phone;
	}//getPhone

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}//setPhone

	public String getImage() 
	{
		return image;
	}//getImage

	public void setImage(String image) 
	{
		this.image = image;
	}//setImage
	
	public String toString()
	{
		return name + " " + phone + " " + image;
	}//toString
}//Contact
