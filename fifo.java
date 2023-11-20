

import java.util.*;
public class fifo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter no of frames:");
        int no_frames=scanner.nextInt();

        System.out.println("Enter no of pages:");
        int no_pages=scanner.nextInt();

        int[] page_rs=new int[no_pages];
        System.out.print("Enter page reference string:");

        for(int i=0;i<no_pages;i++){
            page_rs[i]=scanner.nextInt();
        }

        int[] frames=new int[no_frames];
        Arrays.fill(frames,-1);

        int pagefault=0;
        int curr=0;

        for(int pages:page_rs){
            boolean pagehit=false;

            for(int frame:frames ){
                if(pages==frame){
                    pagehit=true;
                    break;
                }
            }

            if(!pagehit){
                frames[curr]=pages;
                curr=(curr+1)%no_frames;
                pagefault++;
            }

            System.out.print("\nFrames");

            for(int f:frames){
                System.out.print(f+" ");
            }


        }

        System.out.println("\ntotal no of page fault:"+pagefault);
        scanner.close();


    }
}
