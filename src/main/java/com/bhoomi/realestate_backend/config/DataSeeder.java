package com.bhoomi.realestate_backend.config;

import com.bhoomi.realestate_backend.entity.*;
import com.bhoomi.realestate_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TrendingProjectRepository trendingProjectRepository;
    private final FeaturedCityRepository featuredCityRepository;
    private final WhyChooseUsItemRepository whyChooseUsItemRepository;
    private final HowItWorksStepRepository howItWorksStepRepository;
    private final TestimonialRepository testimonialRepository;
    private final SiteSettingsRepository siteSettingsRepository;

    private static final String ADMIN_EMAIL = "admin@bhoomi.com";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    public void run(String... args) {
        seedAdmin();
        seedSiteSettings();
        seedTrendingProjects();
        seedFeaturedCities();
        seedWhyChooseUs();
        seedHowItWorks();
        seedTestimonials();
    }

    private void seedAdmin() {
        if (userRepository.existsByEmail(ADMIN_EMAIL)) return;

        User admin = new User();
        admin.setName("Admin");
        admin.setEmail(ADMIN_EMAIL);
        admin.setPassword(passwordEncoder.encode(ADMIN_PASSWORD));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);
        System.out.println("Seeded admin user: " + ADMIN_EMAIL);
    }

    private void seedSiteSettings() {
        if (siteSettingsRepository.existsById(1L)) return;

        SiteSettings s = new SiteSettings();
        s.setId(1L);
        s.setHeroHeading("Find a place that actually completes your life.");
        s.setHeroSubtext("Discover homes and properties that match the way you want to live.");
        s.setStatsCitiesCount("40+");
        s.setStatsDevelopersCount("680+");
        s.setStatsPropertiesCount("5K+");
        s.setTrendingHeading("Trending Projects");
        s.setTrendingSubtext("The Noteworthy Real Estate in India");
        s.setWhyChooseUsHeading("Building Trust Through Every Transaction");
        s.setWhyChooseUsDescription("We combine verified data, on-ground expertise, and end-to-end legal support to make property buying transparent and stress-free.");
        s.setWhyChooseUsYearsExperience("15+");
        s.setHowItWorksHeading("How It Works");
        s.setHowItWorksSubtext("Your journey to a new home, in four simple steps");
        s.setCitiesHeading("Featured Cities");
        s.setCitiesSubtext("Find your home in the city of your choice");
        s.setTestimonialsHeading("What Our Clients Say");
        s.setTestimonialsSubtext("Real experiences from people who found their home with us");
        s.setCtaHeading("Ready to find your dream property?");
        s.setCtaSubtext("Talk to our advisors today and get a free consultation.");
        s.setContactPhone("+91 9720717160");
        s.setContactPhoneHours("Mon to Sat, 9am to 7pm");
        s.setContactEmail("hello@yourcompany.com");
        s.setContactAddress("Sector 44, Gurgaon, Haryana");
        siteSettingsRepository.save(s);
        System.out.println("Seeded site settings");
    }

    private void seedTrendingProjects() {
        if (trendingProjectRepository.count() > 0) return;

        trendingProjectRepository.save(new TrendingProject(null,
                "Godrej Lakeside Orchards", "Godrej Properties", "Sarjapur Road, Bangalore",
                "2, 3 & 4.5 BHK", "2678 SQ. FT.", "₹ 1.43 Cr - 3.02 Cr",
                "https://images.unsplash.com/photo-1600607687920-4e2a09cf159d?w=1000", true, 1));

        trendingProjectRepository.save(new TrendingProject(null,
                "Prestige Marigold Phase 2", "Prestige Group", "Devanahalli, Bangalore",
                "Plots", "1500 - 2400 SQ. FT.", "₹ 99.75 L - 1.59 Cr",
                "https://images.unsplash.com/photo-1600566753190-17f0baa2a6c3?w=1000", false, 2));

        trendingProjectRepository.save(new TrendingProject(null,
                "Godrej Kukatpally", "Godrej Properties", "Kukatpally, Hyderabad",
                "3 & 4 BHK", "1600 - 3200 SQ. FT.", "₹ 2.20 Cr - 4.40 Cr",
                "https://images.unsplash.com/photo-1600607688969-a5bfcd646154?w=1000", true, 3));

        trendingProjectRepository.save(new TrendingProject(null,
                "Prestige Shantiniketan", "Prestige Group", "Whitefield, Bangalore",
                "2,3,4 BHK", "1418 - 4190 SQ. FT.", "₹ 95.99 L - 2.49 Cr",
                "https://images.unsplash.com/photo-1600607687920-4e2a09cf159d?w=1000", false, 4));

        System.out.println("Seeded trending projects");
    }

    private void seedFeaturedCities() {
        if (featuredCityRepository.count() > 0) return;

        featuredCityRepository.save(new FeaturedCity(null, "Bangalore", "1225",
                "https://images.unsplash.com/photo-1596176530529-78163a4f7af2?w=1000", 1));
        featuredCityRepository.save(new FeaturedCity(null, "Hyderabad", "251",
                "https://aurorealty.com/blog/wp-content/uploads/2025/02/view-historic-building-against-blue-sky.jpg", 2));
        featuredCityRepository.save(new FeaturedCity(null, "Pune", "1671",
                "https://images.unsplash.com/photo-1600607687939-ce8a6c25118c?w=1000", 3));
        featuredCityRepository.save(new FeaturedCity(null, "Gurgaon", "379",
                "https://production-nuego-cms.blr1.digitaloceanspaces.com/static-contents/prod-v1/Hero_Image_557_X_310_px_a71e79f242.jpg", 4));

        System.out.println("Seeded featured cities");
    }

    private void seedWhyChooseUs() {
        if (whyChooseUsItemRepository.count() > 0) return;

        whyChooseUsItemRepository.save(new WhyChooseUsItem(null, "🏠", "Verified Listings",
                "Every property RERA verified before listing.", 1));
        whyChooseUsItemRepository.save(new WhyChooseUsItem(null, "🛡️", "Legal Support",
                "Dedicated legal team for document checks & registration.", 2));
        whyChooseUsItemRepository.save(new WhyChooseUsItem(null, "💰", "Best Price Guarantee",
                "We negotiate directly with builders on your behalf.", 3));
        whyChooseUsItemRepository.save(new WhyChooseUsItem(null, "📞", "Dedicated Advisor",
                "One point of contact from search to key handover.", 4));

        System.out.println("Seeded why-choose-us items");
    }

    private void seedHowItWorks() {
        if (howItWorksStepRepository.count() > 0) return;

        howItWorksStepRepository.save(new HowItWorksStep(null, "01", "🔍", "Search & Explore",
                "Browse thousands of verified listings across 40+ cities, filtered by your exact needs.", 1));
        howItWorksStepRepository.save(new HowItWorksStep(null, "02", "🏠", "Shortlist & Visit",
                "Save your favourites and schedule site visits directly with our advisors, at your convenience.", 2));
        howItWorksStepRepository.save(new HowItWorksStep(null, "03", "📝", "Verify & Negotiate",
                "We help verify RERA status, legal documents, and negotiate the best possible price for you.", 3));
        howItWorksStepRepository.save(new HowItWorksStep(null, "04", "🔑", "Close & Move In",
                "Complete the paperwork with our legal team and get the keys to your new home, hassle-free.", 4));

        System.out.println("Seeded how-it-works steps");
    }

    private void seedTestimonials() {
        if (testimonialRepository.count() > 0) return;

        testimonialRepository.save(new Testimonial(null, "Ananya Sharma", "Bought a 3BHK in Bangalore",
                "https://i.pravatar.cc/100?img=47",
                "The entire process was smooth from search to registration. Their team verified every document so I never had to worry about anything.",
                5, 1));
        testimonialRepository.save(new Testimonial(null, "Rohit Malhotra", "Invested in commercial space, Gurgaon",
                "https://i.pravatar.cc/100?img=12",
                "Best platform for serious buyers. The listings are accurate and the RERA verification badge actually means something here.",
                5, 2));
        testimonialRepository.save(new Testimonial(null, "Priya Nair", "Bought a plot in Pune",
                "https://i.pravatar.cc/100?img=32",
                "I compared 6 different platforms before landing here. The transparency in pricing and the personal advisor support made all the difference.",
                4, 3));

        System.out.println("Seeded testimonials");
    }
}