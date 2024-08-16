package cn.feng.untitled.music.ui.component.impl;

import cn.feng.untitled.music.ui.ThemeColor;
import cn.feng.untitled.music.ui.component.Button;
import cn.feng.untitled.util.data.resource.ResourceType;
import cn.feng.untitled.util.data.resource.ResourceUtil;
import cn.feng.untitled.util.render.RenderUtil;
import cn.feng.untitled.util.render.RoundedUtil;
import lombok.Setter;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

/**
 * @author ChengFeng
 * @since 2024/8/14
 **/
public class IconButton extends Button {
    private final ResourceLocation file;
    private final Runnable action;
    @Setter
    private int size;
    @Setter
    private boolean bg;

    public IconButton(String file, Runnable action) {
        this.file = ResourceUtil.getResource(file, ResourceType.ICON);
        this.action = action;
    }

    @Override
    public void draw() {
        height = size;
        width = size;
        RenderUtil.scaleStart(posX + size / 2f, posY + size / 2f, hovering? (Mouse.isButtonDown(0)? 1.03f : 1.07f) : 1f);
        if (bg) {
            RoundedUtil.drawRound(posX - 2f, posY - 2f, size + 4f, size + 4f, 9.5f, ThemeColor.redColor);
        }
        RenderUtil.drawImage(file, posX, posY, size, size);
        RenderUtil.scaleEnd();
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (hovering && button == 0) {
            action.run();
        }
    }
}
