/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_poolable_entity_tool
File: WAsys_Project_Info.java
Created on: Jun 25, 2020 12:56:11 PM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200625)
*/

package wasys.lib.generic_object_pool.entity_tool.meta;


/**
 * 
 * @author https://github.com/911992
 */
public class WAsys_Project_Info {
    public static final String PROJECT_REPO="https://github.com/911992/WAsys_Poolable_Object_generator_tool";
    public static final String PROJECT_VERSION="0.1";
    public static final String PROJECT_BUILD="20200625";
    public static final String PROJECT_NAME="WAsys Poolable_Object Skeleton Generator";
    public static final String PROJECT_DESC="Simple tool for making skeleton of Poolable_Object (WAsys_simple_generic_object_pool) entities";
    private WAsys_Project_Info(){}
    public static final String PROJECT_SIGNATURE = String.format("%s v%s(%s)", PROJECT_NAME,PROJECT_VERSION,PROJECT_BUILD);
}
