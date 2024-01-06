package fileutils;

import java.io.File;

public class FileRenamer
{

    public static void main(String[] args)
    {
        String directoryPath = "D:/ComfyUI/ComfyUI/models/checkpoints/SD1.5"; // Replace with your directory path
        String[] newFileNames = {"3DAnimationDiffusion_v10.safetensors", "3DAnimationDiffusion_v10.sha256",
                "3DMixCharacter_Realism_v20.safetensors", "A7B3_v10.safetensors", "AbsoluteReality_v181.safetensors",
                "Anime3DMix_1.safetensors", "Animerge_v22.safetensors", "Aniverse_thx_v14.safetensors", "Anything_v3.ckpt",
                "Architectural_v31.safetensors", "ArthemyComics_v50.safetensors", "ArtUniverse_v80.safetensors",
                "AZovyaRPGArtistTools_v3.safetensors", "Babes_v20.safetensors", "BeautifulRealistic_v7.safetensors",
                "Beautyfool_v20.safetensors", "BetterDisneyPixar_v10.safetensors", "BrainDance_v071.safetensors",
                "ChillOutMix_v10.safetensors", "CleanLinearMix_final.safetensors", "Colorful_v31.safetensors",
                "DarkSushi_v40.safetensors", "DreamShaper_v8.safetensors", "DungeonsAndDiffusion_v3.safetensors",
                "EpicPanty_v1.safetensors", "EpicPhotogasm_xPlusPlus_v1.safetensors", "EpicPhotogasm_y_v1.safetensors",
                "EpicRealism_natural_v1.safetensors", "EpicRealism_pe_v5.safetensors", "Faetastic_v2.safetensors",
                "FantasticMix_k1_v1.safetensors", "FrottagePatterns_v1.ckpt", "GhostMix_v20.safetensors",
                "GoliathPerson_dnd.ckpt", "Helloyoung25d_V10fvae.safetensors", "IncredibleWorld_v40.safetensors",
                "KeybitSpace_v07.safetensors", "MajicMix_Realistic_v7.safetensors", "MeinaMix_v110.safetensors",
                "MeinaMix_v8.safetensors", "MeinaMix_Pastel_v6.safetensors", "YorozaStyle_NightSky_v1.safetensors",
                "OmegaCentauri_AlphaMain_v1.safetensors", "PerfectDeliberate_v10.safetensors",
                "PerfectDeliberate_v40.safetensors", "Pope25_v14.safetensors", "RC_3d_v8.safetensors",
                "RC_Anime_v5.safetensors", "RC_Pixar_v2.safetensors", "StableYogi_Realism_v10.safetensors",
                "RealisticVision_v51.safetensors", "RevAnimated_v122.safetensors", "Samaritan3dCartoon_v3.safetensors",
                "SVDN3_RealArt_v1.safetensors", "sd_1.5.safetensors", "Silicon29_v1.safetensors",
                "SilverMoonMix_v13.safetensors", "SoapMix28D_v10.safetensors", "ThisIsReal_v50.safetensors",
                "TinyPlanets_v1.ckpt", "UniverseStable_AnalogPhoto_v70.safetensors", "VirileAnimation_v10.safetensors",
                "VirileFantasy_v11.safetensors", "ZavyComics_b1_v1.safetensors", "ZavyMix_v10.safetensors", "Zero_v1.safetensors",}; // Replace with your new file names

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        System.out.println(files.length);
        System.out.println(newFileNames.length);

        if (files != null && files.length - 1 == newFileNames.length)
        {
            for (int i = 0; i < files.length; i++)
            {
                if (!files[i].isDirectory())
                {
                    File file = files[i];
                    File newFile = new File(directoryPath, newFileNames[i]);
                    System.out.println(file.getName() + "  |  " + newFile.getName());

                    boolean success = file.renameTo(newFile);
                    if (success)
                    {
                        System.out.println(file.getName() + " renamed to " + newFile.getName());
                    } else
                    {
                        System.err.println("Failed to rename " + file.getName());
                    }
                }
            }
        } else
        {
            System.err.println("The number of files in the directory does not match the number of new file names provided.");
        }
    }
}