/**
 * $Id$
 *
 * Copyright (c) 2007 Thomas Beckmann 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.thomas.functional.util.comparator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 15.07.2007
 */
public class ChainedComparator<T> implements Comparator<T>, Serializable {

    private static final long serialVersionUID = 5561001252407719972L;

    private final Comparator<? super T>[] comparators;
    
    public ChainedComparator(Comparator<? super T>... comparators) {

        for (Comparator<? super T> comparator : comparators) {
            if (comparator == null) throw new NullPointerException();
        }
        this.comparators = comparators;
    }

    /**
     * TODO Method documentation
     * 
     * @param o1
     * @param o2
     * @return
     * @see java.util.Comparator#compare(T, T)
     * @author Thomas
     * @since 15.07.2007
     */
    public int compare(T o1, T o2) {

        for (Comparator<? super T> comparator : this.comparators) {
            
            final int ret = comparator.compare(o1, o2);
            
            if (ret != 0) return ret;
        }
        
        return 0;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "ChainedComparator["  + Arrays.toString(this.comparators) + "]";
    }

}
