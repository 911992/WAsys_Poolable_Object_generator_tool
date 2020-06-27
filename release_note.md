# WAsys_Poolable_Object_generator_tool Release Note

repo: https://github.com/911992/WAsys_Poolable_Object_generator_tool  
Author: [911992](https://github.com/911992)  
*(NOTE: following list carries mentionable(not all) changes. For detailed changes, check source code(s))*  

**0.1.2** (Jun 26, 2020) 

0. Fixed the issue about missed import for `Generic_Object_Pool_Policy`
1. `Source_Code::Type_Generator.java`  
    * Fixed the issue, about missed `import` for type `Generic_Object_Pool_Policy` when default pool policy statement is asked
2. `Source_Code::WAsys_Project_Info.java`
    * Updated `PROJECT_VERSION`, and `PROJECT_BUILD` fields
3. Diagrams
    * Updated [`gen_artifact_class_diagram`](./_docs/_diagrams/gen_artifact_class_diagram.svg) (read the dedicated changes [here](./_docs/_diagrams/gen_artifact_class_diagram_release_note.md))
4. Repo
    * Updated `pom.xml` file
        * Chnaged the artifact to version `0.1.2`

<hr/>

**0.1.1** (Jun 26, 2020) 

0. `Source_Code::Type_Generator.java`  
    * Generated `close()` method now doesn't throw `Exception`  
1. `Source_Code::Main_GUI.java`  
    * Reorder package/class-name input elements  
2. `Source_Code::WAsys_Project_Info.java`
    * Updated `PROJECT_VERSION`, and `PROJECT_BUILD` fields
3. Repo
    * Updated `pom.xml` file
        * Chnaged the artifact to version `0.1.1`
    * Added `_ignore` folder to `.gitignore`


<hr/>

**Initial Release 0.1.0** (Jun 25, 2020)