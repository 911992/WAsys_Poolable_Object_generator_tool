# Generated Artifact Class Diagram Version History
repo: https://github.com/911992/WAsys_Poolable_Object_generator_tool  
file: [generated artifact class_diagram](./gen_artifact_class_diagram.svg)  
Author: [911992](https://github.com/911992)  

**0.2.7** (Aug 29, 2020)

* Removed usage of `Pool_Context` class in *WAsys Generic Object Pool* component, since it's no more
* Added `Generic_Object_Pool` in *WAsys Generic Object Pool*
* Added `__factory__:Object_Factory<{USER_TYPE_NAME}>` `static final` field to generated `{USER_TYPE_NAME}` class
* Field `__pool__` now is type-var as `Object_Pool<{USER_TYPE_NAME}>`
* Added `get_standalone_obj_factory(void):Object_Factory<{USER_TYPE_NAME}>` in generated `{USER_TYPE_NAME}` class
* Renamed `__pool__init` static init to `__pool__AND__factory__init`

<hr/>

**0.2.1** (Aug 23, 2020)

* Changes related to `WAsys_simple_generic_object_pool` API change version `0.5.1`
* Removed `Object_Factory` from *WAsys Generic Object Pool* componenet (as version 0.5.1 of related repo)
* Added dependent *Type Signature* componenet from `wasys::lib::java_type_util`
* Nested generated `Factory` class now implements `Object_Factory<{USER_TYPE_NAME}>`

<hr/>

**0.1.5** (Jul 27, 2020)

* Reordered the `reset_state(void):void` method in `{USER_TYPE_NAME}`, to the top(very first member)

<hr/>

**0.1.2** (Jun 26, 2020)

* Added missed `Generic_Object_Pool_Policy` type, and dependency to `{USER_TYPE_NAME}`

<hr/>

**0.1.0** (Jun 25, 2020)

* Initial release