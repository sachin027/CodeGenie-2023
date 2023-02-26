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
        
        //for specific problem
        
//     String ans = "";
//     int k = 0;
//         int max = 0;
//         for(int i=0;i<6;i++){
//             max=marks[i];
//             k=i;
//             for(int j=i;j<7;j++){
//                 if(marks[j]>=max){
//                     k = j;
//                     max=marks[j];
//                 }
//             }
//             int temp = marks[i];
//             marks[i]=max;
//             marks[k]=temp;

//             String temp1 = students[i];
//             students[i]=students[k];
//             students[k]=temp1;

//             String pass = examResults[i];
//             examResults[i]=examResults[k];
//             examResults[k]=pass;
        
//         }
    
//     double y = 0.0;
//     int[] arr = new int[7];
//     for(int i = 0;i<7;i++){
//             y = (double)(7-1-i)/7*100;
            
//             if(y>=50.0 && examResults[i].equals("Passed")){
//                 arr[i]=1;
//             }
//             else{
//                 arr[i]=0;
//             }
//     }

//     for(int i = 0;i<7;i++){
//         if(arr[i]==1 && ans.equals("")){
//             ans =  "\"" + students[i];
//         }else if(arr[i]==1){
//             ans = ans + ","+ students[i];
//         }
//     }
//     return ans+"\"";
        
        //updated solution !!!!!!!!!
        
        
    int n = students.length;
    Map<Integer, String> studentList = new HashMap<>();
    Map<Integer, String> studentResult = new HashMap<>();
    for (int i = 0; i < students.length; i++) {
        studentList.put(marks[i], students[i]);
        studentResult.put(marks[i], examResults[i]);
    }

    int rank = n - (int) (requiredPercentile * n / 100);
    Arrays.sort(marks);

    List<String> res = new ArrayList<>();
    for (int i = n - 1; i > n - rank; i--) {
        if (studentResult.get(marks[i]) == "Passed")
            res.add(studentList.get(marks[i]));
    }
    return String.join(",", res);
    }
  }
