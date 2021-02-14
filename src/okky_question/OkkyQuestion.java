package okky_question;

public class OkkyQuestion {
    int[] oprands;



    public void setoprands(int[] oprands) {
        this.oprands=oprands;

    }



    public void sum() {
        int total=0;

        for(int i=0; i<this.oprands.length; i++) {
            total+=this.oprands[i];



        }System.out.println(total);



    }







    public void avg() {
        int total=0;

        for(int i=0; i<this.oprands.length; i++) {
            total+=this.oprands[i];

        }

        System.out.println(total/this.oprands.length);

    }
}
