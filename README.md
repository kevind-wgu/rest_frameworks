This project represents my research into various Java REST Frameworks in order to see which I liked. The goal was to find something simpler, more modern, less bloated than SpringBoot. Committed are some of my experimentations.

The primary objective was to implement a CRUD REST application for the "JOB" object. If fully implemented it should hopefully contain the following.
- Database Injection
- Object Validation
- Error Handling
- Testing

Not all of the underlying directories work or are fully implemented. To run the partially implemented ones run `docker-compose up -d` and then see the given project readme.

# FrameWorks
## ActiveJ
- Not implemented, some test code
- Didn't spend much time here as it didn't appear very popular or well adopted.

## Avaje
- Mostly implemented (Missing testing)
- Very light framework. Uses annotation processor to hookup a compile time dependency injection framework with a REST framework (Javalin).
- Worked fairly well but struggled with providers. Also struggled with understanding scopes and how to use them properly.
- Generated code from annotation processors is observable (unlike Micronaut) making it easier to look at what the underlying code is doing.

## CXF
- Not Implemented - Some test code

## Dropwizard
- Not Implemented 
- I have previously used this. It worked well and was a fairly easy to use framework.
- Built on top of Jersey
- HK2 is the default injection framework which I did not particularly care for.
- Does have a Guice impl alternative to KH2 but hasn't been maintained in a couple years.
- Ultimately I don't see Dropwizard as the popular framework so I am not going to recommend it.

## Javalin
- See Avaje
- Looks like a fairly minimalistic rest framework. Bare bones, but looked like it was seeing some adoption and looked really straight forward.

## Jersey
- Mostly Implemented
- Uses HK2 as its injection framework. I found it unintuative and painful to use.
  - Getting singletons to work requires manual binding
  - Getting factories to work requires manual binding
  - Default behavior on thrown exceptions doesn't log the exception
  - Ultimately I was unable to get it to auto-construct any service that had manually bound beans without also manually binding those beans. HK2 seems to be a pain in the butt to use. It may or may not support Singletons out of the box (hard to tell).
  - Manually Binding the database wasn't too hard, but it is hard to tell if it is using the right scope.
- Should work. Most of the CRUD service is working.
- Mostly implemented, no tests
- Found it one of the harder frameworks to work with. Very bare bones. Documentation lacking (or I am bad at finding and reading it).
- No logging, Exceptions are lost and forgotten. When things go wrong you get a generic error screen with no information as to what went wrong.
- Painful to use.

## Ktor
- Not Implemented, just trying out kotlin
- Kotlin framework. I used it as an option to explore Kotlin. Not fully implemented.
- It seemed like it would be a useful minimal framework.
- I am not going to recommend at this time as I don't think my team is ready to learn Kotlin.

## Micronaut
- Not Implemented here, see ai-scoreprocessor repo.
- This is not included as I had previously written a service in this framework.
- It is familar if you work in Dropwizard or Spring.
- Seems fairly popular.
- Uses Annotation Processors to create dependency injection.
- A well rounded framework with lots of features.
- Documentation is sometimes hard to read through (One giant page) and I often miss details that either are not in the documentation or are located such that I had a hard time finding them.
- At times I would run into issues that were painful to get around. I struggled to find enough information to tell me exactly what I was doing wrong.
- Plugins are not always the greatest impl. (I particularly did not like the AWS SecretsManager and SSM property integrations)
- Ultimately I liked using this framework once I got it working.
- Has nice testing integration

## Netty
- Not Implemented, just messing with it.
- Spent a little bit of time here looking to see if we could use netty direclty. Ultimately I wouldn't recommend using it directly unless you need something very low level. I would recommend writing a framework on top of it (which Micronaut did)

## Quarkus
- Mostly/Fully Implemented. (Test is commented out but should work if you reset the db)
- Fairly easy to implement
- Very well rounded framework
- Seems quite popular (more so than Micronaut)
- Has nice testing integration
- Guides are fairly through, in my quick CRUD app I really didn't run into many issues.
- Lacking documentation other than the guides. I assume that the guides are not exhaustive on its functionality but am unsure where to go more info?
- Has obvious community that will support you.
- Using the configuration, I am not a fan of including other environments configuration inside the main application.yml. It appears that it will load both the java/resources/application.properties and the test/resources/application.properties though this wasn't detailed in the guides. 
- Included interesting `dev` mode that would refresh the server after code changes similar to how you might work with a UI application. Not sure if I would use it alot or not.

## RestEasy
- Quarkus and Wildfly are specifically mentioned as "Tight integration with Servlet Container" so I didn't investiate further.

## Netty
- Very bare bones network protocol. We are not looking to implement at this low of a level.

## CXF
- Seems to be Spring so I avoided it since we were looking to move away from Spring.


# Dependency Injection Frameworks
## Guice
## HK2
Not a fan
## Dagger 2
## Weld
## Avaje

# Other links
https://dev.to/piczmar_0/framework-less-rest-api-in-java-1jbl
Marcin Piczkowski comment - ... The purpose was to make sth simple from ground up, but the experiment shows it's not that simple after all when the API grows, cause eventually we would come up with reinventing a wheel. My feelings, weather to use it in real app, or stick to well known frameworks like Spring are mixed. Still, I think it's good to know underlying techniques that the frameworks base on.