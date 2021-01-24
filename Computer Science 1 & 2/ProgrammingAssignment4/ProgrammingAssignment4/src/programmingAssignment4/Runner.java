package programmingAssignment4;

public class Runner {

	public static void main(String[] args) {
//		PasswordTester pass = new PasswordTester();
//		PPMPicture picture = new PPMPicture("thomas.ppm");//make sure image is in project
//		picture.setToGrayScale();
//		picture.save("grayscale.ppm");
//		picture.setToNegative();
//		picture.save("negative.ppm");
		
		PPMPicture enterprise = new PPMPicture("enterprise.ppm");
		enterprise.setArtwork();
		enterprise.save("art.ppm");
	}//main
}//class
