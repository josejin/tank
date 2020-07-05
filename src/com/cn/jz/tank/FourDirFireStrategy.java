package com.cn.jz.tank;

public class FourDirFireStrategy  implements  FireStrategy<Tank>{
    @Override
    public void fire(Tank tank) {
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs){
            int bullteX=  tank.x + Tank.TANK_WIDTH/2 - Bullte.BULLE_WIDTH/2;
            int BullteY= tank.y + Tank.TANK_HEIGTH/2 - Bullte.BULLE_HEIGTH/2;
            new Bullte(bullteX,BullteY,dir,tank.tankFrame,tank.group);
        }

    }
}
