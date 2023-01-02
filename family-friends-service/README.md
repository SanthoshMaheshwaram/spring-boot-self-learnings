1. ************************************* // What is UTF-8 (Universal Transformation Format-8 bytes) // ***************************************
    Computer uses binary system to store the information and in binary all data is represented a sequences of 1s and 0s
    and most basic unit of binary is 'bit', which is just a single 1 or 0, and next largest unit of binary is 'byte' which consists of 8 bits, 
    eg: 01101011 
    Every digital asset you’ve ever encountered — from software to mobile apps to websites to Instagram stories — is built on this system of bytes
2. ASCII: Converting Symbols to Binary
   The American Standard Code for Information Interchange (ASCII) was an early standardized encoding system for text. 
   Encoding is the process of converting characters in human languages into binary sequences that computers can process. 
   ASCII’s library includes every upper-case and lower-case letter in the Latin alphabet (A, B, C…), 
   every digit from 0 to 9, and some common symbols (like /, !, and ?). It assigns each of these characters a unique three-digit code and a unique byte.
3. Now, the actual UTF-8 is as follow......
   UTF-8 Characters in Web Development
   UTF-8 is the most common character encoding method used on the internet today, and is the default character set for HTML5. 
   Over 95% of all websites, likely including your own, store characters this way. 
   Additionally, common data transfer methods over the web, like XML and JSON, are encoded with UTF-8 standards. 
4. Since it’s now the standard method for encoding text on the web, all your site pages and databases should use UTF-8.
5. A content management system or website builder will save your files in UTF-8 format by default, 
   but it’s still a good idea to make sure you’re sticking to this best practice. 
6. Text files encoded with UTF-8 must indicate this to the software processing it. 
   Otherwise, the software won’t properly translate the binary back into characters. (similarly we have UTF-16)
   if you find your website’s pages are using up an inordinate amount of space, or if your text is littered with ▢s and �s, 
   it’s time to put your new knowledge of UTF-8 to work.
   ***************************************************** // END OF UTF-8 // **********************************************************************


NOTE:
*****
for spring security newer version changes
https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter


some help-full Exceptions
**************************
1. LazyInitializationException:
What is Lazy loading:
*********************
The aim of lazy loading is to save resources by not loading related objects into memory when we load the main object. Instead, 
we postpone the initialization of lazy entities until the moment they're needed. Hibernate uses proxies and collection wrappers to implement lazy loading.
When retrieving lazily-loaded data, there are two steps in the process. First, there's populating the main object, and second, 
retrieving the data within its proxies. Loading data always requires an open Session in Hibernate.
The problem arises when the second step happens after the transaction has closed, which leads to a LazyInitializationException.

LazyInitializationException, Indicates an attempt to access not-yet-fetched data outside-of a session context.
For example, when an uninitialized proxy or collection is accessed after the session was closed.

solution: https://thorben-janssen.com/lazyinitializationexception/
solution-1: spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
solution-2: annotate the method with, @org.springframework.transaction.annotation.Transactional(readOnly = true)
conclusion:
    1-with property:
    However, the solution works slowly, because Hibernate starts a transaction for us on each fetch.
    It works perfectly for demos and when we don't care about performance issues. 
    This may be ok if used to fetch a collection that contains only one element, 
    or a single related object in a one-to-one relationship.
    2-with-out property:
    Without the property, we have fine-grained control of the transactions, and we no longer face performance issues.
    Overall, this is not a production-ready feature, and to Hibernate documentation warns us:
    Although enabling this configuration can make LazyInitializationException go away, it's better to use a fetch plan that guarantees that all 
    properties are properly initialized before the Session is closed.

2. org.hibernate.TransientObjectException: 
object references an unsaved transient instance - save the transient instance before flushing: org.jangaon.familyfriendsservice.entity.AppUserRoles; 
nested exception is java.lang.IllegalStateException:

The TransientObjectException is “Thrown when the user passes a transient instance to a session method that expects a persistent instance”.
Now, the most straightforward solution to avoid this exception would be to get a persisted instance of the required entity by either persisting 
a new instance or fetching one from the database and associate it in the dependant instance before persisting it. However, doing so only covers 
this particular scenario and doesn't cater to other use cases.
To cover all scenarios, we need a solution to cascade our save/update/delete operations for entity relationships that depend on the existence of 
another entity. We can achieve that by using a proper CascadeType in the entity associations.

solution-1: cascade = CascadeType.ALL, whenever we save/delete main object the associated object will also be persisted/removed accordingly.
solution-2: 

3. Multiple representations of the same entity [org.fnf.entity.AppUser#adf1e21c-d8ea-4483-a7a5-15ba57431e35] are being merged Managed:









/*
@Test
public void whenSaveEntitiesWithOneToOneAssociation_thenSuccess() {
User user = new User("Bob", "Smith");
Address address = new Address("London", "221b Baker Street");
user.setAddress(address);
Session session = sessionFactory.openSession();
session.beginTransaction();
session.save(user);
session.getTransaction().commit();
session.close();
}
*/











https://www.marcobehler.com/guides/spring-security#oauth2
https://www.javatpoint.com/ejb-tutorial



