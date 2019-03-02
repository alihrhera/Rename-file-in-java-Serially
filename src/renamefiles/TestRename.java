package renamefiles;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali HrHera
 */
public class TestRename {
    

private ArrayList<String> listOfFile() {
    ArrayList<String> Files=new ArrayList<String>();
    for (final File fileEntry : foldr.listFiles()) {
        if (!fileEntry.isDirectory()) {
            Files.add(fileEntry.getName()+"");
        }
    }
    System.out.println(Files.size());
    return Files;
//    
}
      private File foldr;
        public void Start(){
            try {
                File folder = new File(getFileDirectory());
                foldr=folder;
                Rename(listOfFile(),getCreatFolderstat()); // creat folder for every se

            }catch(IOException e){
                System.out.println("eror "+e.getMessage());
            }

        }

    
     
    private String folderdir;
    private int  Seasons;
    private int  Episodes ;

    private  String getFileDirectory() {
        if (FileDirectory.contains("/")){
                return FileDirectory.replace("//", "\\");

        }else if (FileDirectory.contains("//")){
                            return FileDirectory.replace("/", "\\");
        }
     return FileDirectory.replace("//", "\\");

    }

    public  void setFileDirectory(String fileDirectory) {
        FileDirectory = fileDirectory;
    }

    private String FileDirectory;    //="C://Users//Ali HrHera//Desktop//testfolder//";

    boolean CreatFolder;

    private boolean getCreatFolderstat(){ return CreatFolder;}

    public void SetCreatFolderStat(boolean crat){
    CreatFolder=crat;
    }

    private int getSeasons() {
        return Seasons;
    }

    public void setSeasons(int seasons) {
        Seasons = seasons;
    }

    private int getEpisodes() {
        return Episodes;
    }

    public void setEpisodes(int episodes) {
        Episodes = episodes;
    }
    
    
    

    public void Rename(ArrayList<String> list, boolean creatFolder) throws IOException{
        String fileExtanshan;
        folderdir=foldr.getPath()+"\\";
        String filename;
        String sename;
        int conter=0;
       
        for (int i=1;i<=getSeasons(); i++){
            sename="SE"+i;
                if (creatFolder){
                    File theDir = new File(foldr.getPath()+"\\"+sename);
                          theDir.mkdir();
                          folderdir=theDir.getPath();
                }
                    for(int j=1; j<=getEpisodes();j++){
                        filename="\\"+sename+"_"+j+"";
                        if(conter<list.size()){
                            fileExtanshan=list.get(conter).substring(list.get(conter).indexOf("."));
                                 File file = new File(foldr.getPath()+"\\"+list.get(conter));
                                 File file2 = new File(folderdir+filename+fileExtanshan);
                            if (file2.exists()){
                            throw new java.io.IOException("file exists");
                            }else {
                                    Files.move(file.toPath(), file2.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING); 
                            }
                            System.out.println(file2.isFile());
                            conter++;

                        }
                    }
                 }

                }

}

