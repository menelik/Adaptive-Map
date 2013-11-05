/*   AUTHOR :           Emmanuel Pietriga (emmanuel.pietriga@inria.fr)
 *   Copyright (c) INRIA, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
 *
 * $Id: L3FSInverseCosineLens.java 2102 2009-06-23 08:57:56Z rprimet $
 */


package fr.inria.zvtm.lens;


/**Profile: inverse cosine - L(3) (intermediate between a circle and a square)<br>Size expressed as an absolute value in pixels*/

public class L3FSInverseCosineLens extends FSInverseCosineLens {

    /**
     * create a lens with a maximum magnification factor of 2.0
     */
    public L3FSInverseCosineLens(){
	super();
    }

    /**
     * create a lens with a given maximum magnification factor
     *
     *@param mm maximum magnification factor, mm in [0,+inf[
     */
    public L3FSInverseCosineLens(float mm){
	super(mm);
    }

    /**
     * create a lens with a given maximum magnification factor, inner and outer radii
     *
     *@param mm maximum magnification factor, mm in [0,+inf[
     *@param outerRadius outer radius (beyond which no magnification is applied - outward)
     *@param innerRadius inner radius (beyond which maximum magnification is applied - inward)
     */
    public L3FSInverseCosineLens(float mm, int outerRadius, int innerRadius){
	super(mm, outerRadius, innerRadius);
    }

    /**
     * create a lens with a given maximum magnification factor, inner and outer radii
     *
     *@param mm maximum magnification factor, mm in [0,+inf[
     *@param outerRadius outer radius (beyond which no magnification is applied - outward)
     *@param innerRadius inner radius (beyond which maximum magnification is applied - inward)
     *@param x horizontal coordinate of the lens' center (as an offset w.r.t the view's center coordinates)
     *@param y vertical coordinate of the lens' center (as an offset w.r.t the view's center coordinates)
     */
    public L3FSInverseCosineLens(float mm, int outerRadius, int innerRadius, int x, int y){
	super(mm, outerRadius, innerRadius, x, y);
    }

    public void gf(float x, float y, float[] g){
	d = Math.pow(Math.pow(Math.abs(x-sw-lx), 3) + Math.pow(Math.abs(y-sh-ly), 3), L3FSLinearLens.onethird);
	if (d <= LR2)
	    g[0] = g[1] = MM;
	else if (d <= LR1)
	    g[0] = g[1] = MM-c*(float)Math.acos(Math.pow(d*a+b-1,2));
	else
	    g[0] = g[1] = 1;
    }

}
