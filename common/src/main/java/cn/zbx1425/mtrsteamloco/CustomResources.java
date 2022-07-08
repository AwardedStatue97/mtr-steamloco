package cn.zbx1425.mtrsteamloco;

import cn.zbx1425.mtrsteamloco.model.ModelTrainD51;
import net.minecraft.server.packs.resources.ResourceManager;
import org.lwjgl.opengl.GL33;

import java.io.IOException;

public class CustomResources {

    public static void init(ResourceManager resourceManager) {
        try {
            MainClient.shaderManager.reloadShaders(resourceManager);
        } catch (IOException e) {
            Main.LOGGER.error("Failed to load shader:", e);
        }

        mtr.client.TrainClientRegistry.register(
                "d51", "train_19_2", new ModelTrainD51(), "mtr:s_train", "D51", 0xFF0000,
                "", "", 0.0F, 0.0F, false, "", null
        );

        int vaoPrev = GL33.glGetInteger(GL33.GL_VERTEX_ARRAY_BINDING);
        ModelTrainD51.initGlModel(resourceManager);
        GL33.glBindVertexArray(vaoPrev);
    }
}
