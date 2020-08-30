/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_poolable_entity_tool
File: Type_Generator.java
Created on: Jun 25, 2020 12:22:59 PM
    @author https://github.com/911992
 
History:
    0.2.7 (20200829)
        • Generated artifact now follows the new changes related to WAsys_simple_generic_object_pool-v0.5.7
        • Generated artifact now have static functions to get the standalone(out-of-pool) object fatory (get_standalone_obj_factory(void):Object_Factory<{USER_TYPE_NAME}>)
        • Generated artifact now has a static private factory variable that holds an instance of the internal pool (__factory__)
        • Updated the imports, removed import for Pool_Context, and add Generic_Object_Pool instead

    0.2.1 (20200823)
        • Changes related to WAsys_simple_generic_object_pool API change version 0.5.1
        • Inline Factory class now implements wasys.lib.java_type_util.reflect.type_sig.Object_Factory

    0.1.5 (20200727)
        • Fixed a very stupid string comparision using == operator, (╯°□°)╯︵ ┻━┻
        • Added TODO comment for reset_state function
        • Replaced reset_state next to user members

    0.1.4 (20200630)
        • Removed redundant whitespace of generated type javadoc(leading extra space)

    0.1.3 (20200629)
        • Fixed the bad blank line of generated type javadoc

    0.1.2 (20200626)
        • Fixed the issue, about missed import for type Generic_Object_Pool_Policy when defailt pool policy statement is asked

    0.1.1 (20200626)
        • Generated close() method now doesn't throw Exception

    initial version: 0.1(20200625)
*/

package wasys.lib.generic_object_pool.entity_tool;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import wasys.lib.generic_object_pool.entity_tool.meta.WAsys_Project_Info;


/**
 * 
 * @author https://github.com/911992
 */
public class Type_Generator {
    
    private static final String ESSENTIAL_IMPORTS[]={
        "wasys.lib.java_type_util.reflect.type_sig.Object_Factory",
        "wasys.lib.generic_object_pool.Object_Pool",
        "wasys.lib.generic_object_pool.Generic_Object_Pool",
        "wasys.lib.generic_object_pool.api.Poolable_Object"
    };
    
    private static final String ESSENTIAL_IMPORTS_ALL;
    static{
        StringBuilder _sb=new StringBuilder(275);
        boolean _need_nl=false;
        for(int a=0;a<ESSENTIAL_IMPORTS.length;a++){
            if(_need_nl){
                _sb.append("\n");
            }
            _sb.append("import ");
            _sb.append(ESSENTIAL_IMPORTS[a]);
            _sb.append(";");
            _need_nl = true;
        }
        ESSENTIAL_IMPORTS_ALL = _sb.toString();
    }

    private static final String OBJECT_POOL_POLICY_IMPORT = "wasys.lib.generic_object_pool.Generic_Object_Pool_Policy";
    
    private static final String WORKING_VARIALBE_NAME = "__object_is_busy__";
    
    private static final String WORKING_VARIALBE_SETTER_FUNC_NAME = "__invalidate__";
    
    private static final String WORKING_VARIALBE_GETTER_FUNC_NAME = "__is_invalid__";
    
    private static final String POOL_VARIABLE_NAME = "__pool__";
    
    private static final String OBJ_FACTORY_VARIABLE_NAME = "__factory__";
    
    private static final String INTERNAL_FACTORY_CLASS_NAME = "Factory";
    
    private static final String NEW_INSTANCE_FUNC_NAME = "get_an_instance";
    
    private static final String GET_POOL_VAR_FUNC_NAME = "get_pool";
    
    private static final String GET_STANDALONE_OBJ_FACTORY_FUNC_NAME = "get_standalone_obj_factory";
    
    private static final String BACK_TO_POOL_METHOD_NAME = "back_to_pool";
    
    static final String DEFAULT_POL_POLICY_STATEMENT = "Generic_Object_Pool_Policy.DEF_INS";
    
    private static final String DEFAULT_TYPE_NAME_PLACEHOLDER ="<<my_class(⌐■_■)>>";

    private Type_Generator() {
    }
    
    /**
     * Generates a {@code Poolable_Object} entity, from given arguments.
     * @param arg_package package name of the type (could be {@code null}, or zero-length(empty))
     * @param arg_type_name name of the type/class. If {@code null} or zero-length(empty), then a placeholder will be used
     * @param arg_pool_policy the string literal/statement to use, as pool policy when initializing the pool var. ({@code null}, or zero-length(empty) string will lead it to default as {@code })
     * @param arg_out the stream result will be written to. If {@code null}, then {@code STDOUT} will be used.
     */
    public static final void generate_type(String arg_package , String arg_type_name , String arg_pool_policy,OutputStream arg_out){
//        if(arg_package != null && (arg_package=arg_package.trim()).length()==0 ){
//            arg_package = null;
//        }
//        if(arg_type_name!=null && (arg_type_name=arg_type_name.trim()).length()==0){
//            arg_type_name = null;
//        }
//        if(arg_pool_policy!=null && (arg_pool_policy=arg_pool_policy.trim()).length()==0 ){
//            arg_pool_policy = null;
//        }
        if(arg_pool_policy==null || arg_pool_policy.length()==0){
            arg_pool_policy = DEFAULT_POL_POLICY_STATEMENT;
        }
        if(arg_type_name == null || arg_type_name.length() ==0){
            arg_type_name = DEFAULT_TYPE_NAME_PLACEHOLDER;
        }
        if(arg_package==null || arg_package.length()==0){
            arg_package = null;
        }
        if(arg_out==null){
            arg_out = System.out;
        }
        
        PrintStream _out=new PrintStream(arg_out);
        
        
        /*printing the package*/
        if(arg_package!=null){
            _out.printf("package %s;\n\n",arg_package);
        }
        
        /*imports*/
        _out.printf("%s\n",ESSENTIAL_IMPORTS_ALL);
        if(DEFAULT_POL_POLICY_STATEMENT.equals(arg_pool_policy)){
            _out.printf("import %s;\n", OBJECT_POOL_POLICY_IMPORT);
        }
        _out.printf("\n");
        
        /*sample usage*/
        _out.printf("/**\n");
        _out.printf(" * This class is a poolable type, make sure any acquired instance will be released once is no more needed.\n");
        _out.printf(" * <p>Sample Usage (using {@code try-with-resources}) (<b>recommended</b>)</p>\n");
        _out.printf(" * <pre>\n");
        _out.printf(" * try(%s _ins = %s.%s();){\n",arg_type_name,arg_type_name,NEW_INSTANCE_FUNC_NAME);
        _out.printf(" * ...\n");
        _out.printf(" * }//automatically releasing the instance\n");
        _out.printf(" * </pre>\n");
        _out.printf(" * \n");
        _out.printf(" * <p>Sample Usage</p>\n");
        _out.printf(" * <pre>\n");
        _out.printf(" * %s _ins = %s.%s();\n",arg_type_name,arg_type_name,NEW_INSTANCE_FUNC_NAME);
        _out.printf(" * ...\n");
        _out.printf(" * _ins.%s();//IMPORTANT\n",BACK_TO_POOL_METHOD_NAME);
        _out.printf(" * </pre>\n");
        _out.printf(" */\n");
        
        /*class definition*/
        _out.printf("public class %s implements Poolable_Object,AutoCloseable{\n\n", arg_type_name);
        
        /*printing the tool siganture*/
        _out.printf("\t/*\n");
        _out.printf("\t  This entity was generated by\n");
        _out.printf("\t  %s\n",WAsys_Project_Info.PROJECT_SIGNATURE);
        _out.printf("\t  %s\n",WAsys_Project_Info.PROJECT_REPO);
        _out.printf("\t-----------\n");
        _out.printf("\t  File were created on:%s\n", new Date(System.currentTimeMillis()));
        _out.printf("\t*/\n\n");
        
        /*commend to user-defined stuffs*/
        _out.printf("\t/*User-defined members --- start*/\n\n");
        
        _out.printf("\t/*User-defined members ----- end*/\n\n");
        
        /*reset_state method impl*/
        _out.printf("\t@Override\n");
        _out.printf("\tpublic void reset_state() {\n");
        _out.printf("\t\t//Mark this instance as out-of-work, DO NOT CHANGE\n");
        _out.printf("\t\tthis.%s();\n\n",WORKING_VARIALBE_SETTER_FUNC_NAME);
        _out.printf("\t\t/*User-defined instance reset --- start*/\n");
        _out.printf("\t\t//TODO: reset/clearout attributes/instance here (e.g. nulling stuffs, closing things, etc...)\n");
        _out.printf("\t\t/*User-defined instance reset ----- end*/\n");
        _out.printf("\t}\n\n");
        
        /*pool, and object factory declaration*/
        /*pool*/
        _out.printf("\t/*object pool*/\n");
        _out.printf("\tfinal static Object_Pool %s;\n\n",POOL_VARIABLE_NAME);
        /*object_factory*/
        _out.printf("\t/*object factory*/\n");
        _out.printf("\tfinal static Object_Factory<%s> %s;\n\n", arg_type_name,OBJ_FACTORY_VARIABLE_NAME);
        
        _out.printf("\t/*object pool, and object factory initialization*/\n");
        _out.printf("\tstatic{\n");
        _out.printf("\t\t%s=new %s();\n", OBJ_FACTORY_VARIABLE_NAME,INTERNAL_FACTORY_CLASS_NAME);
        _out.printf("\t\t%s = Generic_Object_Pool.new_pool_instance(%s,%s);\n",POOL_VARIABLE_NAME,OBJ_FACTORY_VARIABLE_NAME,arg_pool_policy);
        _out.printf("\t}\n\n");
        
        /*working variable*/
        _out.printf("\t/*Working variable\n\t  •true when object is being used\n\t  •false when idle and in pool context\n\t  please leave it alone*/\n");
        _out.printf("\tprivate volatile boolean %s;\n\n",WORKING_VARIALBE_NAME);
        
        /*factory class*/
        _out.printf("\t/*internal factory class for the type*/\n");
        _out.printf("\tprivate static class %s implements Object_Factory<%s>{\n\n", INTERNAL_FACTORY_CLASS_NAME,arg_type_name);
        _out.printf("\t\t@Override\n");
        _out.printf("\t\tpublic %s create_object(Class arg_type) {\n",arg_type_name);
        _out.printf("\t\t\treturn new %s();\n",arg_type_name);
        _out.printf("\t\t}\n\n");
        _out.printf("\t}\n\n");
        
        /*static method for getting a new instnace*/
        _out.printf("\t/*Returns a pooled instance from the pool*/\n");
        _out.printf("\tpublic static final %s %s(){\n",arg_type_name,NEW_INSTANCE_FUNC_NAME);
        _out.printf("\t\t%s _res = (%s)%s.get_an_instance();\n",arg_type_name,arg_type_name,POOL_VARIABLE_NAME);
        _out.printf("\t\t_res.%s=true;\n",WORKING_VARIALBE_NAME);
        _out.printf("\t\treturn _res;\n");
        _out.printf("\t}\n\n");
        
        /*getter for pool*/
        _out.printf("\t/*method to return %s*/\n",POOL_VARIABLE_NAME);
        _out.printf("\tpublic static Object_Pool<%s> %s(){\n", arg_type_name,GET_POOL_VAR_FUNC_NAME);
        _out.printf("\t\treturn %s;\n\t}\n\n", POOL_VARIABLE_NAME);
        
        /*standalone object factory*/
        _out.printf("\t/*method to return out-of-pool(standalone) object factory\n\tNOTE: generated object SHOULD NOT be released back to the pool*/\n");
        _out.printf("\tpublic static Object_Factory<%s> %s(){\n",arg_type_name,GET_STANDALONE_OBJ_FACTORY_FUNC_NAME);
        _out.printf("\t\treturn %s;\n\t}\n\n", OBJ_FACTORY_VARIABLE_NAME);
        
        /*private constructor*/
        _out.printf("\tprivate %s(){\n\t\t/*User-defined instance initialization(if any)*/\n\t}\n\n",arg_type_name);
        
        /*getter for valdiation*/
        _out.printf("\t/*(internal use)method to check if instance is valid or not*/\n");
        _out.printf("\tprivate boolean %s(){\n", WORKING_VARIALBE_GETTER_FUNC_NAME);
        _out.printf("\t\treturn (%s==false);\n\t}\n\n", WORKING_VARIALBE_NAME);
        
        /*setter for valdiation*/
        _out.printf("\t/*(internal use)invalidates this instance*/\n");
        _out.printf("\tprivate void %s(){\n", WORKING_VARIALBE_SETTER_FUNC_NAME);
        _out.printf("\t\t%s=false;\n\t}\n\n", WORKING_VARIALBE_NAME);
        
        /*back to pool method*/
        _out.printf("\t/*returns this instance to the pool(%s)\n\tUsing the same instance after its release is an UB*/\n",POOL_VARIABLE_NAME);
        _out.printf("\tpublic void %s(){\n",BACK_TO_POOL_METHOD_NAME);
        _out.printf("\t\tif(this.%s()){\n",WORKING_VARIALBE_GETTER_FUNC_NAME);
        _out.printf("\t\t\treturn;\n");
        _out.printf("\t\t}\n");
        _out.printf("\t\t%s.release_an_instance(this);\n",POOL_VARIABLE_NAME);
        _out.printf("\t}\n\n");
        
        /*post_create method impl*/
        _out.printf("\t@Override\n");
        _out.printf("\tpublic void post_create() {\n");
        _out.printf("\t}\n\n");
        
        /*pre_destroy method impl*/
        _out.printf("\t@Override\n");
        _out.printf("\tpublic void pre_destroy() {\n");
        _out.printf("\t}\n\n");
        
        /*set_pool method impl*/
        _out.printf("\t@Override\n");
        _out.printf("\tpublic void set_pool(Object_Pool arg_pool) {\n");
        _out.printf("\t}\n\n");
        
        /*close method impl*/
        _out.printf("\t@Override\n");
        _out.printf("\tpublic void close(){\n");
        _out.printf("\t\tthis.back_to_pool();\n");
        _out.printf("\t}\n\n");
        
        /*end of class def*/
        _out.printf("}\n");
        
        _out.flush();
    }
    
//    public static void main(String[] args) {
//        String _type_name = "Rand_Byte";
//        String _package = null;
//        String _pol= null;
//        OutputStream _out=System.out;
//        generate_type(_package, _type_name, _pol, _out);
//    }
    
}
