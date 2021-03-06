<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<@pp.changeOutputFile name="Bind.java" />
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
package com.thomas.functional.bind;

<#list 1..max as i>
import com.thomas.functional.function.Function${i};
</#list>

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 21.05.2007
 */
public final class Bind {

    private Bind() {

        //intentionally left empty 
    }

<#list 1..max as from>
<#list 0..max as to>
    public static <R, <@csv 1..from; i>T${i}</@csv>> BindFrom${from}To${to}<R, <@csv 1..from; i>T${i}</@csv>> asFunction${to}(
            Function${from}<R, <@csv 1..from; i>T${i}</@csv>> func) {
        
        return new BindFrom${from}To${to}<R, <@csv 1..from; i>T${i}</@csv>>(func);
    }

</#list>
</#list>
}
