package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.final_project.model.enums.Category.COLD;
import static com.ironhack.final_project.model.enums.Category.HOT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PopulateDBTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @BeforeEach
    public void setUp() {

        userRepository.deleteAll();
        coffeeRepository.deleteAll();

        User user1 = new User("henry18", "bio", "password");
        userRepository.save(user1);

        User user2 = new User("kathy_78", "https://res.cloudinary.com/drrxks8d9/image/upload/v1660969978/find-a-market/tzfhtl7xw1mulqk7dlmx.jpg","bio", "password");
        userRepository.save(user2);

        User user3 = new User("Sirsee43", "https://res.cloudinary.com/drrxks8d9/image/upload/v1660978819/find-a-market/qznd8ufrfldfkfpl2all.jpg","bio", "password");
        userRepository.save(user3);

        List<String> ingredients1 = new ArrayList<>();
        ingredients1.add("2 tablespoons hot water");
        ingredients1.add("2 tablespoons instant coffee");
        ingredients1.add("2 tablespoons sweetener");
        ingredients1.add("1/2 cup milk");
        ingredients1.add("1/4 cup Kahlúa");
        ingredients1.add("ice");
        List<String> steps1 = new ArrayList<>();
        steps1.add("Add water, coffee, and sweetener to bowl and whip on medium to high speed or whisk.");
        steps1.add("Fill glass with ice, pour Kahlúa in, then milk. Top with a dollop of whipped coffee.");

        Coffee coffee1 = new Coffee(
                "Boozy Whipped Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685963696/Coffee/whipped-coffee-cocktail-2_lidbrj.webp",
                "What's better than fluffy, sweet whipped coffee over milk? Boozy whipped coffee, of course! This easy cocktail pairs coffee liqueur with milk, all topped with a little cloud of whipped coffee for an Instagram-worthy drink. Perfect for brunch or after dinner, and easy to make vegan.",
                "5 minutes",
                ingredients1,
                steps1,
                "Use any sort of granulated sweetener in your whipped coffee, like sugar, coconut sugar, or granulated Swerve. We love whole milk in our whipped coffee because of how rich and delicious it makes the drink, but almond, coconut, oat, or whatever milk you have on hand is fine! For a vegan drink, just use non-dairy milk! We used Kahlúa in our drink, but you can use any coffee liqueur you like.",
                user1);
        coffeeRepository.save(coffee1);

        List<String> ingredients2 = new ArrayList<>();
        ingredients2.add("6 tablespoons sugar");
        ingredients2.add("2 tablespoons unsweetened cocoa powder");
        ingredients2.add("2 teaspoons chili powder");
        ingredients2.add("1 ½ teaspoons cinnamon");
        ingredients2.add("¼ teaspoon cayenne pepper (optional)");
        ingredients2.add("½ cup water");
        ingredients2.add("2 cups cold coffee");
        ingredients2.add("Ice");
        ingredients2.add("milk/cream of choice");
        List<String> steps2 = new ArrayList<>();
        steps2.add("Sift sugar, cocoa, and seasonings together.");
        steps2.add("Mix ½ Cup cocoa mix with ½ cup water. Heat in microwave for 20-30 seconds until sugar mix dissolves into water. Chill.");
        steps2.add("Stir cocoa 'syrup' into two cups cold coffee.");
        steps2.add("Serve over ice with milk");

        Coffee coffee2 = new Coffee(
                "Iced Mexican mocha",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685268504/Coffee/Iced-Mexican-Mocha-Drink-Recipe-2-1024x1536_oyku8a.jpg",
                "This iced Mexican mocha recipe is an easy way to enjoy some of that delicious combination of chocolate and spices. Great recipe for any Mexican holiday parties, including Cinco de Mayo and Día de los Muertos festivities.",
                "10 minutes",
                ingredients2,
                steps2,
                "The cayenne pepper doesn't provide a great deal of spice in this recipe, but feel free to omit or adjust measurement as desired.",
                user3);
        coffeeRepository.save(coffee2);

        List<String> ingredients3 = new ArrayList<>();
        ingredients3.add("175gr Fresh mango");
        ingredients3.add("70ml Cold brew coffee");
        ingredients3.add("70ml Sweet cream coffee creamer, frothed");
        List<String> steps3 = new ArrayList<>();
        steps3.add("Purée mango in a blender or food processor until smooth.");
        steps3.add("Place mango purée into a glass, top with cold brew coffee and creamer.");
        steps3.add("Pour over ice if desired.");

        Coffee coffee3 = new Coffee(
                "Cold Mango Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685269592/Coffee/2367a87b0adc30f3e31778322eec55d8_u0qlw8.jpg",
                "Smooth fruit flavor with a kick of caffeine and sweet cream to get you going in the morning, or any time of day.",
                "10 minutes",
                ingredients3,
                steps3,
                "Enjoy!",
                user2);
        coffeeRepository.save(coffee3);

        List<String> ingredients4 = new ArrayList<>();
        ingredients4.add("3 tablespoons of coffee granules");
        ingredients4.add("3 tablespoons of hot water");
        ingredients4.add("3 tablespoons of granulated sugar");
        ingredients4.add("1 brewed espresso");
        ingredients4.add("Handful of ice");
        ingredients4.add("Dairy-free milk");
        ingredients4.add("Biscoff cookies (optional)");
        List<String> steps4 = new ArrayList<>();
        steps4.add("In a bowl, add in the coffee, hot water, and granulated sugar.");
        steps4.add("Whisk vigorously for around 5-8 minutes until thick and creamy, then set aside.");
        steps4.add("Fill a glass with ice, and pour over dairy-free milk.");
        steps4.add("Fill the glass with how much milk you like.");
        steps4.add("Brew espresso and pour over the milk.");
        steps4.add("Spoon of coffee cream ontop.");
        steps4.add("Serve with a crumbled Biscoff cookie and cookie on the side.");

        Coffee coffee4 = new Coffee(
                "Biscoff Cloud Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685963795/Coffee/Vegan_cloud_coffee_nnjcqy.jpg",
                "Say hello to one of the most delicious coffees EVER! You may have seen this type of coffee trending recently, so I thought I'd give in to the trend and try it out! Oh my, my question is, how haven't I had one of these before..it's delicious!",
                "5 minutes",
                ingredients4,
                steps4,
                "Enjoy fresh and chilled!",
                user3);
        coffeeRepository.save(coffee4);

        List<String> ingredients5 = new ArrayList<>();
        ingredients5.add("2 tbsp brown sugar");
        ingredients5.add("1.5 tbsp water");
        ingredients5.add("1/2 tsp vanilla");
        ingredients5.add("2-3 shots espresso");
        ingredients5.add("1/4 tsp cinnamon");
        ingredients5.add("1 pour oatmilk");
        List<String> steps5 = new ArrayList<>();
        steps5.add("Combine brown sugar, water, and vanilla in a small saucepan. Bring to a simmer over medium-high heat and stir continuously for 2-3 minutes. Remove from heat and set aside.");
        steps5.add("Add syrup, ice, cinnamon, and espresso in a shaker and shake vigorously for about 1 minute until frothy.");
        steps5.add("Pour the entire shaker into a glass, add more ice if needed, and top with oatmilk!");

        Coffee coffee5 = new Coffee(
                "Iced Brown Sugar Oatmilk Shaken Espresso",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685964336/Coffee/IcedBrownSugarOatmilkShakenEspresso5-1022x1536_aakgfg.jpg",
                "Amazingly creamy, while being dairy-free. Just strong enough to taste the rich espresso, but not too strong to give me the jitters all day.",
                "6 minutes",
                ingredients5,
                steps5,
                "Depending on how sweet you like your coffee, you can reduce the amount of brown sugar to as low as a 1/2 tablespoon and the flavor will still come through. Just also reduce the water and vanilla accordingly. ",
                user1);
        coffeeRepository.save(coffee5);

        List<String> ingredients6 = new ArrayList<>();
        ingredients6.add("2 Tbsp instant coffee");
        ingredients6.add("2 Tbsp white granulated sugar");
        ingredients6.add("2 Tbsp water (hot)");
        ingredients6.add("1/2 cup milk");
        ingredients6.add("Ice");
        List<String> steps6 = new ArrayList<>();
        steps6.add("In a large mixing bowl, add coffee, sugar and HOT water");
        steps6.add("Whisking by hand - using a whisk, first mix the coffee, sugar and water until everything is melted. Then start whisking!!! It should form a hard peak in about 2 minute and 30-40 seconds OR do the challenge and whisk about 400 times.");
        steps6.add("Whisking using a hand mixer or stand mixer - first mix at lowest speed until all the coffee and sugar are dissolved. Then turn the speed to highest setting and mix for 1 min 30 seconds or until hard peaks form. I have a Kitchenaid stand mixer and on it, it takes about 1 min and 30 seconds on highest speed. Handmixer probably is going to be a little longer since it's not as powerful but should work fine. Set aside.");
        steps6.add("Fill 2/3rd of a cup with cold milk (about 1/2 cup) and add some ice.");
        steps6.add("Spoon the foam and add it to the top of the cup. Top it with Dalgona pieces or try sprinkle the top with some hot cocoa powder or cinnamon. Mix it with a spoon to enjoy it as a latte or just as it is as you get a little bit of milk and foam in one sip. ENJOY!!!");

        Coffee coffee6 = new Coffee(
                "Dalgona Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685963595/Coffee/2ee8124cf986d29f499202fac499698f_mqaemx.jpg",
                "Dalgona Coffee is a cold latte drink that comes with a velvety smooth and sweet coffee foam on top. The combination of cold milk and the bittersweet coffee is simply a match made in heaven. And the best part is that you can make it without any special machines - all you need is some arm muscle and patience.",
                "4 minutes",
                ingredients6,
                steps6,
                "Use large mixing bowl (having enough space for your whisk to whip air in) and round whisk (fork or spoon will be too hard). Tilt at an angle.",
                user1);
        coffeeRepository.save(coffee6);

        List<String> ingredients7 = new ArrayList<>();
        ingredients7.add("⅔ cup cold water");
        ingredients7.add("3 espresso shots");
        ingredients7.add("1 cup ice");
        List<String> steps7 = new ArrayList<>();
        steps7.add("Pour cold water into a cup.");
        steps7.add("Add espresso.");
        steps7.add("Top drink with ice.");

        Coffee coffee7 = new Coffee(
                "Ice Americano",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685290466/Coffee/iced-americano-7-1024x1536_aeuwzd.jpg",
                "With just 3 ingredients consisting of ice, espresso, and water, an Iced Americano is one of the easiest and simplest espresso drinks to make.",
                "2 minutes",
                ingredients7,
                steps7,
                "Because Iced Americano is made with espresso, you should be able to see crema along the top, which you won't see in iced coffee.",
                user3);
        coffeeRepository.save(coffee7);

        List<String> ingredients8 = new ArrayList<>();
        ingredients8.add("1 tablespoon vanilla syrup");
        ingredients8.add("¾ cup cold brew coffee");
        ingredients8.add("1 cup ice");
        ingredients8.add("⅓ cup half & half");
        ingredients8.add("1 tablespoon vanilla syrup");
        ingredients8.add("1 tablespoon pumpkin sauce");
        ingredients8.add("¼ teaspoon pumpkin spice");
        List<String> steps8 = new ArrayList<>();
        steps8.add("Pour half & half, vanilla syrup, and pumpkin sauce into a French press.");
        steps8.add("Place French press lid and move the plunger up and down to make cold foam.");
        steps8.add("Put vanilla syrup, cold brew, and ice into a cup.");
        steps8.add("Top drink with cold foam and a dusting of pumpkin spice.");

        Coffee coffee8 = new Coffee(
                "Pumpkin Cream Cold Brew",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685964425/Coffee/starbucks-pumpkin-cream-cold-brew-8-1024x1536_zhyl22.jpg",
                "Pumpkin Cream Cold Brew is a refreshing, caffeinated coffee drink sweetened with vanilla syrup and made creamy with pumpkin cream cold foam. Pumpkin spice topping is dusted on top of the the iced drink.",
                "5 minutes",
                ingredients8,
                steps8,
                "Make your own pumpkin spice topping by combining: ground cinnamon, ginger, nutmeg and cloves.",
                user2);
        coffeeRepository.save(coffee8);

        List<String> ingredients9 = new ArrayList<>();
        ingredients9.add("2 tablespoon Vietnamese dark-roast ground coffee");
        ingredients9.add("1/3 cup water");
        ingredients9.add("1/4 cup sweetened condensed milk, chilled");
        ingredients9.add("6 tablespoon unsweetened coconut cream from 1 can coconut milk");
        ingredients9.add("2 cup ice");
        List<String> steps9 = new ArrayList<>();
        steps9.add("Heat water until it just barely begins to boil.");
        steps9.add("Remove screen insert from a phin filter and add coffee. Tap the filter slightly to evenly spread out the coffee grounds. Place screen insert on top of coffee and place filter over a glass.");
        steps9.add("When water is ready, pour a splash (about 1-2 tablespoons) of the hot water into filter to allow coffee grounds to expand and bloom. When coffee begins to drip through, add remaining water. Place lid on filter and let coffee drip into glass.");
        steps9.add("Once almost all of the water is drained and coffee has stopped dripping (about 5 minutes), remove the filter and chill espresso in the refrigerator for 15-30 minutes");
        steps9.add("In a blender, blend the sweetened condensed milk, coconut cream, and ice together until smooth and frothy. Pour the slushy into two serving  glasses. If desired, chill the slushy in the freezer for about 15 minutes for a thicker consistency.");
        steps9.add("Pour espresso over the slushy, dividing the espresso equally between the 2 glasses.");

        Coffee coffee9 = new Coffee(
                "Vietnamese Coconut Coffee Frappé",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685964479/Coffee/Vietnamese-Coconut-Coffee-R2-2-1024x1536_qr2dbm.jpg",
                "This Vietnamese iced coconut coffee is a popular drink in cafés all over Vietnam. It's a blended coconut slushy made with coconut cream, sweetened condensed milk, and ice that gets topped with some Vietnamese coffee.",
                "10 minutes",
                ingredients9,
                steps9,
                "To get the coconut cream, put a can of coconut milk in the refrigerator for about an hour. Then, carefully open the can and spoon off the thick layer of cream from the top.",
                user1);
        coffeeRepository.save(coffee9);

        List<String> ingredients10 = new ArrayList<>();
        ingredients10.add("Handful of ice");
        ingredients10.add("1 brewed espresso");
        ingredients10.add("45ml of dairy-free milk");
        ingredients10.add("Caramel sauce");
        ingredients10.add("20ml of dairy-free milk for foaming");
        List<String> steps10 = new ArrayList<>();
        steps10.add("Fill a glass halfway with ice.");
        steps10.add("Drizzle over some caramel sauce.");
        steps10.add("Fill the glass halfway with dairy-free milk.");
        steps10.add("Pour over the brewed and cooled espresso.");
        steps10.add("Foam the dairy-free milk and add one top of the coffee.");

        Coffee coffee10 = new Coffee(
                "Caramel Iced Latte",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685964558/Coffee/caramel_iced_latte_xe8n3b.jpg",
                "Be your own barista with this absolutely delicious cooling iced coffee! Rich espresso with dairy-free milk, swirled with caramel sauce and dairy-free milk foam makes for the most delicious coffee! ",
                "3 minutes",
                ingredients10,
                steps10,
                "Finish with a drizzle of caramel sauce and enjoy!",
                user1);
        coffeeRepository.save(coffee10);

        List<String> ingredients11 = new ArrayList<>();
        ingredients11.add("150ml Very strong coffee or espresso");
        ingredients11.add("2 Egg yolks");
        ingredients11.add("1 Tablespoon sweetened condensed milk");
        ingredients11.add("1 Teaspoon granulated sugar, optional");
        ingredients11.add("Chocolate shavings or cocoa powder, for garnish");
        List<String> steps11 = new ArrayList<>();
        steps11.add("Brew coffee or espresso. While it's steeping, set your glass in a cup full of hot water to keep it warm.");
        steps11.add("Meanwhile, place egg and sweetened condensed milk in a large jar. Use an electric mixer with a whisk attachment, and whisk together the egg and condensed milk for 5-6 minutes. Mixture will become very frothy and smooth.");
        steps11.add("Serve immediately with chocolate shavings, or cocoa powder.");

        Coffee coffee11 = new Coffee(
                "Vietnamese egg coffee",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685968969/Coffee/220720_bnnf8u.webp",
                "Vietnamese Egg Coffee, Cà Phê Trứng, is a custardy dessert-like coffee made with strongly brewed Vietnamese coffee topped with a sweet, rich yet light, silky foam mixture made from sweetened condensed milk and egg yolk.  It can almost be described as tiramisu in a mug.",
                "10 minutes",
                ingredients11,
                steps11,
                "Excellent with shortbread cookies!",
                user2);
        coffeeRepository.save(coffee11);

        List<String> ingredients12 = new ArrayList<>();
        ingredients12.add("2 espresso (a double shot)");
        ingredients12.add("1 Tbsp Nutella");
        ingredients12.add("50-100ml of whole milk");
        List<String> steps12 = new ArrayList<>();
        steps12.add("Make a double shot of espresso and stir in a heaping teaspoon of Nutella until it's dissolved and the spoon comes out nearly clean.");
        steps12.add("Steam or froth your milk in a glass measuring cup using your espresso machine. If you don't have an expresso machine, this can easily be done by heating the milk in the microwave for one minute. Then, insert a wire whisk into the cup of heated milk and spin the whisk handle quickly between your hands, similar to how you'd see someone warm up their hands near a fireplace. The whisk should do just the trick in creating frothy milk.");
        steps12.add("Next, pour the espresso into a small coffee mug, then fill with about an ounce of milk and top with froth.");

        Coffee coffee12 = new Coffee(
                "Nutella Macchiato",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685294189/Coffee/Nutella-Machhiato-8-1000x667_xkvb2q.webp",
                "What do you get when you combine two of my favorite things? Nutella recipes that also use coffee! The chocolate-y hazelnut goodness Nutella with coffee is a winning combination, and you'll love this amazing dessert-worthy coffee drink recipe — a Nutella Macchiato. ",
                "11 minutes",
                ingredients12,
                steps12,
                "Enjoy!",
                user1);
        coffeeRepository.save(coffee12);

        List<String> ingredients13 = new ArrayList<>();
        ingredients13.add("2 Shots of espresso");
        ingredients13.add("½ cup chai concentrate");
        ingredients13.add("½ cup whole milk, or preferred milk alternative");
        List<String> steps13 = new ArrayList<>();
        steps13.add("Place ½ cup chai concentrate in a microwave-safe mug and heat until steaming (about 30 seconds). Pour into the espresso shots and stir to combine.");
        steps13.add("Meanwhile, use your milk frother to heat the milk. Pour steamed milk over the espresso and chai mixture.");
        steps13.add("Garnish with a pinch of chai spice blend to serve, if desired.");
        steps13.add("Fill a glass with ice. Pour in the espresso shots, ½ cup chai concentrate, and ½ cup milk. Stir to combine.");
        steps13.add("Garnish with a pinch of chai spice blend to serve, if desired.");

        Coffee coffee13 = new Coffee(
                "Dirty chai latte",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685294848/Coffee/dcb7cb1890d9a828859cb0f753b1517a_dicyin.jpg",
                "This dirty chai latte is a blend of bold espresso, sweet & spicy chai concentrate, and your favorite milk in one delicious coffee recipe. Making a homemade version is easier than a drive-thru run to Starbucks! Enjoy this drink any time of year hot or iced.",
                "5 minutes",
                ingredients13,
                steps13,
                "If you're someone who is sensitive to caffeine, you can find decaf espresso and decaf black tea at most grocery stores or online. Substituting with decaf options means you can still enjoy the wonderful rich, sweet, and spicy flavor of this latte without over-doing it on caffeine.",
                user3);
        coffeeRepository.save(coffee13);

        List<String> ingredients14 = new ArrayList<>();
        ingredients14.add("3 cups brewed coffee");
        ingredients14.add("1/3 cup (45 g) cashews (unsalted and untoasted)");
        ingredients14.add("2 packed tablespoons (25 g) organic dark brown sugar");
        ingredients14.add("½ teaspoon ground ginger");
        ingredients14.add("¼ teaspoon ground cinnamon (plus more for sprinkling)");
        ingredients14.add("A pinch of allspice");
        ingredients14.add("½ teaspoon vanilla extract");
        List<String> steps14 = new ArrayList<>();
        steps14.add("In the pitcher of a high-speed blender, combine about two-thirds of the brewed coffee with the cashews, brown sugar, ginger, cinnamon, allspice, and vanilla. Blend, starting on low and increasing the speed to medium-high or high until the coffee is smooth and frothy, 2-3 minutes total.");
        steps14.add("Add in the remaining coffee and blend again.");
        steps14.add("Pour into large mugs and dust with cinnamon if you like.");


        Coffee coffee14 = new Coffee(
                "Cashew gingersnap latte",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685964647/Coffee/e0d8346cbdc9d8db546bbd697f8c6c02_e8suy0.jpg",
                "Spicy, creamy, vegan gingersnap lattes can be yours in minutes with ingredients you probably have in your pantry.",
                "10 minutes",
                ingredients14,
                steps14,
                "Leftover coffee is lovely the next day served chilled or over ice. Reheated, the coffee tends to thicken, so we like it best when made fresh.",
                user2);
        coffeeRepository.save(coffee14);

        List<String> ingredients15 = new ArrayList<>();
        ingredients15.add("1 cup whole milk");
        ingredients15.add("1 tbsp sugar");
        ingredients15.add("85g semi-sweet chocolate chunks");
        ingredients15.add("1/4 tsp red food coloring");
        ingredients15.add("1/4 tsp vanilla extract");
        ingredients15.add("1/2 cup fresh brewed coffee");
        List<String> steps15 = new ArrayList<>();
        steps15.add("Place milk and granulated sugar in medium saucepan.");
        steps15.add("Bring to a simmer on medium heat, stirring to dissolve sugar.");
        steps15.add("Remove from heat.");
        steps15.add("Stir in chocolate until melted.");
        steps15.add("Stir in food color, coffee and vanilla.");

        Coffee coffee15 = new Coffee(
                "Red Velvet latte",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685295947/Coffee/Screenshot_2023-05-28-19-43-11-113-edit_com.android.chrome_cutjo4.jpg",
                "This sinful red velvet latte is the perfect indulgent treat that can also double as an afternoon pick me up. Coffee never tasted so good!",
                "15 minutes",
                ingredients15,
                steps15,
                "Serve warm",
                user3);
        coffeeRepository.save(coffee15);

        List<String> ingredients16 = new ArrayList<>();
        ingredients16.add("1 ½ cups milk");
        ingredients16.add("2 tablespoons vanilla syrup");
        ingredients16.add("2 shots of espresso");
        ingredients16.add("2 teaspoons caramel sauce");
        List<String> steps16 = new ArrayList<>();
        steps16.add("Froth milk using an electric milk frother or with the steam wand from an espresso machine. Another method is to simmer milk on the stovetop, pour it into a French press, then pump the plunger a few times to create froth.");
        steps16.add("Put vanilla syrup and frothed milk into a cup.");
        steps16.add("Add espresso shots.");
        steps16.add("Drizzle caramel sauce on top.");

        Coffee coffee16 = new Coffee(
                "Caramel Macchiato",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685296422/Coffee/caramel-macchiato-6a-1024x1536_w3jwea.jpg",
                "A Caramel Macchiato is a vanilla flavored latte but the order in which the ingredients go into the drink is what makes it different. Frothed milk goes in first, then the espresso. In a latte, the espresso goes in first, then the frothed milk.",
                "5 minutes",
                ingredients16,
                steps16,
                "Make a batch of homemade vanilla syrup ahead of time. It'll keep in the refrigerator for up to 2 weeks.",
                user2);
        coffeeRepository.save(coffee16);

        List<String> ingredients17 = new ArrayList<>();
        ingredients17.add("¼ cup espresso");
        ingredients17.add("¼ cup sweetened condensed milk");
        List<String> steps17 = new ArrayList<>();
        steps17.add("Brew espresso.");
        steps17.add("Add sweetened condensed milk to a mug.");
        steps17.add("Pour espresso on top of sweetened condensed milk.");

        Coffee coffee17 = new Coffee(
                "Café Bombon",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685296933/Coffee/image-3-1-1200x690_g0ahdn.jpg",
                "Coffee drink originating from Spain. It's two ingredients - espresso and sweetened condensed milk. When put together, it forms a layered look as the sweetened condensed milk holds the espresso up without mixing when poured in like milk does.",
                "2 minutes",
                ingredients17,
                steps17,
                "You can make another version, 'Frothy Cafe Bombon', frothing milk in a milk frother and pour the milk in the espresso. Top with foamed milk.",
                user1);
        coffeeRepository.save(coffee17);

        List<String> ingredients18 = new ArrayList<>();
        ingredients18.add("1/4 cup chocolate syrup");
        ingredients18.add("1 teaspoon coconut extract");
        ingredients18.add("2 cups hot coffee");
        ingredients18.add("1/2 cup dairy or coconut milk");
        ingredients18.add("1/2 cup toasted coconut");
        ingredients18.add("Whipped cream, for serving");
        List<String> steps18 = new ArrayList<>();
        steps18.add("In the bottom of one coffee mug stir together 2 tablespoons chocolate syrup and 1/2 coconut extract.");
        steps18.add("Pour in 1 cup hot coffee and stir until dissolved.");
        steps18.add("Stir in 1/4 cup milk.");
        steps18.add("Repeat with a second coffee mug.");
        steps18.add("Top both with whipped cream and toasted coconut.");

        Coffee coffee18 = new Coffee(
                "Toasted coconut mocha",
                HOT,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685964726/Coffee/1b3e3ba6fe089b0ba2508c61573783db_rgur7h.jpg",
                "If you love chocolate, coconut, and coffee, then you'll love these hot Toasted Coconut Mochas topped with homemade whipped cream. The perfect pick me up when you need an energy boost.",
                "5 minutes",
                ingredients18,
                steps18,
                "Enjoy!",
                user3);
        coffeeRepository.save(coffee18);
    }

    @Test
    public void findAll_allEntities_AllTheLists() {
        List<User> userList = userRepository.findAll();
        List<Coffee> coffeeList = coffeeRepository.findAll();

        System.out.println(userList);
        System.out.println(coffeeList);

        assertEquals(3, userList.size());
        assertEquals(18, coffeeList.size());
    }
}

