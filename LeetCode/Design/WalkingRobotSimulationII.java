/// https://leetcode.com/problems/walking-robot-simulation-ii/description/


class Robot {
    private int x = 0, y = 0, i = 0;
    private int w, h;
    private String dir;
    private final String[] dirs = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        w = width-1;
        h = height-1;
        dir = dirs[0];
    }
    
    public void step(int num) {
        if (num == 0) return;

        int perimeter = 2 * (w + h);
        num %= perimeter;

        if (num == 0) {
            if(x==0 && y==0) i=3;
            else if(x==0 && y==h) i=2;
            else if(x==w && y==0) i=0;
            else if(x==w && y==h) i=1;

            dir = dirs[i];
            return;
        }

        int avSteps = 0;

        if (dir.equals(dirs[0])) { 
            avSteps = Math.min(num, w - x);
            num -= avSteps;
            x += avSteps;

        } else if (dir.equals(dirs[1])) {
            avSteps = Math.min(num, h - y);
            num -= avSteps;
            y += avSteps;
        } else if (dir.equals(dirs[2])) {
            avSteps = Math.min(num, x);
            num -= avSteps;
            x -= avSteps;
        } else { 
            avSteps = Math.min(num, y);
            num -= avSteps;
            y -= avSteps;
        }

        if(avSteps == 0) {
            i = (++i)%4;
            dir = dirs[i];
        }

        step(num);
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dir;
    }
}