public class array {
    public static void main(String a[]){
        int nums[][]=new int [3][4];
        int random =0;

        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                nums[i][j]=(int)(Math.random()*100);
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
        for(int n[] : nums){
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){}
            }
        }
    }

    public static class demop {
    }
}
