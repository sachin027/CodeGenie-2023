public class StudentScreener {
    public static void main(String[] args) throws Exception {
      int totalStudents = 7;
      int totalMarks = 1000;
      float requiredPercentile = 50f;
  
      int[] marks = {800, 300, 750, 760, 680, 790, 640};
      String[] students = { "Kartik", "Devang", "Pari", "Ketan", "Sheetal", "Darshana", "Mohan" };
      String[] examResults = {"Passed", "Failed", "Passed", "Failed", "Passed", "Passed", "Passed"};
  
      String eligiblStudents = getEligibleStudents(totalStudents, students, marks, examResults, totalMarks, requiredPercentile);
      System.out.println(eligiblStudents);
    }
  
    public static String getEligibleStudents(int totalStudents, String[] students, int[] marks, String[] examResults, int totalMarks, float requiredPercentile) throws Exception {
      //TODO: Implement this function and remove below line, which throws exception
    String ans = "";
    int k = 0;
        int max = 0;
        for(int i=0;i<6;i++){
            max=marks[i];
            k=i;
            for(int j=i;j<7;j++){
                if(marks[j]>=max){
                    k = j;
                    max=marks[j];
                }
            }
            int temp = marks[i];
            marks[i]=max;
            marks[k]=temp;

            String temp1 = students[i];
            students[i]=students[k];
            students[k]=temp1;

            String pass = examResults[i];
            examResults[i]=examResults[k];
            examResults[k]=pass;
        
        }
    
    double y = 0.0;
    int[] arr = new int[7];
    for(int i = 0;i<7;i++){
            y = (double)(7-1-i)/7*100;
            
            if(y>=50.0 && examResults[i].equals("Passed")){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
    }

    for(int i = 0;i<7;i++){
        if(arr[i]==1 && ans.equals("")){
            ans =  "\"" + students[i];
        }else if(arr[i]==1){
            ans = ans + ","+ students[i];
        }
    }
    return ans+"\"";
    }
  }