# WAsys_Poolable_Object_generator_tool Release Note

repo: https://github.com/911992/WAsys_Poolable_Object_generator_tool  
Author: [911992](https://github.com/911992)  
*(NOTE: following list carries mentionable(not all) changes. For detailed changes, check source code(s))*  

**0.1.5** (Jul 27, 2020) 

0. `Source_Code::Type_Generator.java`  
    * Fixed a very stupid string comparision using `==` operator, `(╯°□°)╯︵ ┻━┻`
    * Added `TODO` comment for `reset_state()` function
    * Replaced `reset_state()` next to user members section
1. `Source_Code::WAsys_Project_Info.java`
    * Updated `PROJECT_VERSION`, and `PROJECT_BUILD` fields
2. Diagrams
    * Updated [`gen_artifact_class_diagram`](./_docs/_diagrams/gen_artifact_class_diagram.svg) (read the dedicated changes [here](./_docs/_diagrams/gen_artifact_class_diagram_release_note.md))
3. Repo
    * Updated `pom.xml` file
        * Chnaged the artifact to version `0.1.5`        
    * Updated `README.md` file
        * Added missed generated class diagram file(in caption)
    * Updated the [graphical interface screenshot](./_docs/_images/graphical_interface_sample.png)

<hr/>

**0.1.4** (Jun 30, 2020) 

0. Fixed the issue about one redundant leading whitespace of generated type javadoc
1. `Source_Code::Type_Generator.java`  
    * Removed redundant whitespace of generated type javadoc(leading extra space)  
2. `Source_Code::WAsys_Project_Info.java`
    * Updated `PROJECT_VERSION`, and `PROJECT_BUILD` fields
3. Repo
    * Updated `pom.xml` file
        * Chnaged the artifact to version `0.1.4`
    * Updated the [graphical interface screenshot](./_docs/_images/graphical_interface_sample.png)

<hr/>

**0.1.3** (Jun 29, 2020) 

0. Fixed the issue about blank line of generated type javadoc
1. `Source_Code::Type_Generator.java`  
    * Fixed the bad blank line of generated type javadoc
2. `Source_Code::WAsys_Project_Info.java`
    * Updated `PROJECT_VERSION`, and `PROJECT_BUILD` fields
3. Repo
    * Updated `pom.xml` file
        * Chnaged the artifact to version `0.1.3`
    * Updated the [graphical interface screenshot](./_docs/_images/graphical_interface_sample.png)

<hr/>

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