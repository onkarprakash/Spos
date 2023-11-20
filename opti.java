import java.util.*;
import java.util.ArrayList;

public class opti {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter no of frames:");
        int no_frames=scanner.nextInt();

        System.out.println("Enter no of page references:");
        int no_pagerf=scanner.nextInt();

        System.out.println("Enter page reference string");
        scanner.nextLine();
        String input=scanner.nextLine();
        String[] rfstring=input.split(" ");
        if (rfstring.length!=no_pagerf){
            System.out.println("no of references do not match");
            scanner.close();
            return;
        }
        ArrayList<Integer>frames=new ArrayList<>();
        int pagefaults=0;

        for(int i=0;i<no_pagerf;i++){
            int page=Integer.parseInt(rfstring[i]);

            if(!frames.contains(page)){
                pagefaults++;
                if(frames.size()<no_frames){
                    frames.add(page);
                }
                else{
                    int index=predictOptimal(frames,rfstring,i);
                    frames.set(index,page);
                }
            }

        }
        System.out.println("no of pagefaults:"+pagefaults);

        scanner.close();
    }

    private static int predictOptimal(ArrayList<Integer>frames,String[] rfStrings,int curr){
        int farthest=-1;
        int index=-1;
        for(int i=0;i<frames.size();i++){
            int frame=frames.get(i);
            int j;
            for( j=curr;j<rfStrings.length;j++){
                if(frame==Integer.parseInt(rfStrings[j])){
                    if(j>farthest){
                        farthest=j;
                        index=i;
                    }
                    break;
                }
            }
            if(j==rfStrings.length){
                return i;
            }
        }
        return (index==-1)?0:index;
    }
}
