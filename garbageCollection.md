1、Reference Counting Collector  
2、Tracing Collector 
Tracing collector algorithms 
 
3、Compacting Collector 
4、Copying Collector 
5、Generational Collector  
6、Adaptive Collector 
 
 
 
1.Reference Counting Collector  
 
def:Reference counting collectors keep track of how many references are pointing to each Java object. Once the count for an object becomes zero, the memory can be immediately reclaimed. 
 
pros:This immediate access to reclaimed memory is the major advantage of the reference-counting approach to garbage collection. 
 
cons:The main difficulty with reference counting collectors is keeping the reference counts accurate. Another well-known challenge is the complexity associated with handling circular structures. 
 
cons-scenarios:  If two objects reference each other and no live object refers to them, their memory will never be released. Both objects will forever remain with a non-zero count. Reclaiming memory associated with circular structures requires major analysis, which brings costly overhead to the algorithm, and hence to the application. 
 
 
2.Tracing Collector 
 
def: Tracing collectors are based on the assumption that all live objects can be found by iteratively tracing all references and subsequent references from an initial set of known to be live objects.Once the tracing collector has found all live objects, it will reclaim the remaining memory. 
Tracing collector algorithms 
Copying collectors: Traditional copying collectors use a from-space and a to-space -- that is, two separately defined address spaces of the heap. At the point of garbage collection, the live objects within the area defined as from-space are copied into the next available space within the area defined as to-space. When all the live objects within the from-space are moved out, the entire from-space can be reclaimed. When allocation begins again it starts from the first free location in the to-space. 
 
 
 
 
 
 
 
 
 
 
