package Java.OOPs.Polymorphism;

/**
 * java_.OOPs.Polymorphism is the ability of an object to take on many forms
 * is used to a parent class reference is refer to a child class object.
 */
interface Vegetarian{
}
class Animal{
}
class Deer extends Animal implements Vegetarian{
}
class Main{
    Deer d = new Deer();
    Animal a = d;
    Vegetarian v = d;
    Object o = d;
}
//        A Deer IS-A Animal
//        A Deer IS-A Vegetarian
//        A Deer IS-A Deer
//        A Deer IS-A Object
